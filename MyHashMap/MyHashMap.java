public class MyHashMap<K, V> {
	private ListNode<KeyValue<K, V>>[] buckets;
	private int objectCount;
	private double loadFactorLimit;

	// Constructor: creates a hash map with the given initial bucket size and load
	// factor limit
	public MyHashMap(int bucketCount, double loadFactorLimit) {
		this.buckets = (ListNode<KeyValue<K, V>>[]) new ListNode[bucketCount];
		fillArrayWithSentinels(buckets);
		this.objectCount = 0;
		this.loadFactorLimit = loadFactorLimit;
	}

	// Constructor: creates an empty hash map with default parameters
	public MyHashMap() {
		this(10, .75);
	}

	private static void fillArrayWithSentinels(ListNode[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ListNode();
		}
	}

	// Return a pointer to the bucket array
	public ListNode<KeyValue<K, V>>[] getBuckets() {
		return this.buckets;
	}

	// Returns true if this map is empty; otherwise returns false.
	public boolean isEmpty() {
		return (objectCount == 0);
	}

	// Returns the number of entries in this map.
	public int size() {
		return objectCount;
	}

	// Return the bucket index for the key
	// Use .hashCode(), but be aware that hashCode can return negative numbers!
	private int whichBucket(K key) {
		/* -- IMPLEMENT THIS -- */
		int bucket = key.hashCode() % buckets.length;
		if (bucket < 0) {
			return bucket + buckets.length;
		} else {
			return bucket;
		}
	}

	// Returns the current load factor (objCount / buckets)
	public double currentLoadFactor() {
		/* -- IMPLEMENT THIS -- */
		return (double) objectCount / buckets.length;
	}

	// Return true if the key exists as a key in the map, otherwise false.
	// Use the .equals method to check equality.
	public boolean containsKey(K key) {
		/* -- IMPLEMENT THIS -- */
		ListNode<KeyValue<K, V>> bucket = buckets[whichBucket(key)];
		while (!bucket.getNext().isSentinel()) {
			bucket = bucket.getNext();
			if (bucket.getEntry().getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	// Return true if the value exists as a value in the map, otherwise false.
	// Use the .equals method to check equality.
	public boolean containsValue(V value) {
		/* -- IMPLEMENT THIS -- */
		for (ListNode<KeyValue<K, V>> bucket : buckets) {
			while (!bucket.getNext().isSentinel()) {
				bucket = bucket.getNext();
				if (bucket.getEntry().getValue().equals(value)) {
					return true;
				}
			}
		}
		return false;
	}

	// Puts a key-value pair into the map.
	// If the key already exists in the map you should *not* add the key-value pair.
	// Return true if the pair was added; false if the key already exists.
	// If a pair should be added, add it to the END of the bucket.
	// After adding the pair, check if the load factor is greater than the limit.
	// - If so, you must call rehash with double the current bucket size.
	public boolean put(K key, V value) {
		/* -- IMPLEMENT THIS -- */
		if (containsKey(key)) {
			return false;
		}
		ListNode<KeyValue<K, V>> bucketSentinel = buckets[whichBucket(key)];
		ListNode<KeyValue<K, V>> current = bucketSentinel;

		while (!current.getNext().isSentinel()) {
			current = current.getNext();
		}
		current.setNext(new ListNode<KeyValue<K, V>>(new KeyValue<K, V>(key, value), current, bucketSentinel));
		objectCount++;

		if (currentLoadFactor() > loadFactorLimit) {
			rehash(buckets.length * 2);
		}
		return true;
	}

	// Returns the value associated with the key in the map.
	// If the key is not in the map, then return null.
	public V get(K key) {
		/* -- IMPLEMENT THIS -- */
		ListNode<KeyValue<K, V>> bucket = buckets[whichBucket(key)];
		while (!bucket.getNext().isSentinel()) {
			bucket = bucket.getNext();
			if (bucket.getEntry().getKey().equals(key)) {
				return bucket.getEntry().getValue();
			}
		}
		return null;
	}

	// Remove the pair associated with the key. Return true if successful, false if
	// the key did not exist
	public boolean remove(K key) {
		/* -- IMPLEMENT THIS -- */
		ListNode<KeyValue<K, V>> bucket = buckets[whichBucket(key)];
		while (!bucket.getNext().isSentinel()) {
			bucket = bucket.getNext();
			if (bucket.getEntry().getKey().equals(key)) {
				ListNode<KeyValue<K, V>> previous = bucket.getPrevious();
				bucket.getNext().setPrevious(previous);
				previous.setNext(bucket.getNext());
				objectCount--;
				return true;
			}
		}
		return false;
	}

	// Rehash the map so that it contains the given number of buckets
	// Loop through all existing buckets, from 0 to length
	// rehash each object into the new bucket array in the order they appear on the
	// original chain.
	// I.e. if a bucket originally has (sentinel)->J->Z->K, then J will be rehashed
	// first,
	// followed by Z, then K.
	public void rehash(int newBucketCount) {
		/* -- IMPLEMENT THIS -- */
		ListNode<KeyValue<K, V>>[] original = buckets;
		buckets = (ListNode<KeyValue<K, V>>[]) new ListNode[newBucketCount];
		fillArrayWithSentinels(buckets);
		for (ListNode<KeyValue<K, V>> bucket : original) {
			while (!bucket.getNext().isSentinel()) {
				bucket = bucket.getNext();
				ListNode<KeyValue<K, V>> newBucketSentinel = buckets[whichBucket(bucket.getEntry().getKey())];
				ListNode<KeyValue<K, V>> current = newBucketSentinel;

				while (!current.getNext().isSentinel()) {
					current = current.getNext();
				}
				current.setNext(new ListNode<KeyValue<K, V>>(new KeyValue<K, V>(
						bucket.getEntry().getKey(), bucket.getEntry().getValue()), current, newBucketSentinel));
			}
		}
	}

	// The output should be in the following format:
	// [ n, k | { b#: k1,v1 k2,v2 k3,v3 } { b#: k1,v1 k2,v2 } ]
	// n is the objCount
	// k is the number of buckets
	// For each bucket that contains objects, create a substring that indicates the
	// bucket index
	// And list all of the items in the bucket (in the order they appear)
	// E.g. "[ 3, 10 | { b3: Andy,Stout Andrew,Theiss } { b7: Adam,Varney } ]"
	public String toString() {
		/* -- IMPLEMENT THIS -- */
		StringBuilder sb = new StringBuilder("[ " + objectCount + ", " + buckets.length + " | ");
		for (int i = 0; i < buckets.length; i++) {
			ListNode<KeyValue<K, V>> node = buckets[i];
			if (!node.getNext().isSentinel()) {
				sb.append("{ b" + i + ": ");
				while (!node.getNext().isSentinel()) {
					node = node.getNext();
					sb.append(node.getEntry().getKey().toString() + ","
							+ node.getEntry().getValue().toString() + " ");
				}
				sb.append("} ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
