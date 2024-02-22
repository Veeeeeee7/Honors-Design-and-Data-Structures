
public class KeyValue<K,V> {
	private final K key;
	private V value;
	
	public KeyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public boolean equals(KeyValue<K,V> other) {
		return this.key.equals(other.key)&& this.value.equals(other.value); 
	}
	
}
