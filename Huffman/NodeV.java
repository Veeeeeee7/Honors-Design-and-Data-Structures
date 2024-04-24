public class NodeV implements Comparable<NodeV> {
    public int frequency;
    public char value;

    public NodeV left;
    public NodeV right;

    public NodeV(int frequency) {
        this.frequency = frequency;
    }

    public NodeV(int frequency, char value) {
        this.frequency = frequency;
        this.value = value;
    }

    @Override
    public int compareTo(NodeV other) {
        return frequency - other.frequency;
    }

    @Override
    public String toString() {
        return "frequency: " + frequency + " \t value: " + value;
    }
}
