public class VectorRecord {
    private String id;
    private String text;
    private double[] vector;

    public VectorRecord(String id, String text, double[] vector) {
        this.id = id;
        this.text = text;
        this.vector = vector;
    }

    // 1. ADD THIS METHOD RIGHT HERE:
    public String getId() {
        return id;
    }

    public double[] getVector() {
        return vector;
    }

    public String getText() {
        return text;
    }
}