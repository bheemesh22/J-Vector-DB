public class VectorRecord {
    // 1. The ID: How we identify the book (like a barcode)
    private String id;

    // 2. The Metadata: The actual text/title
    private String text;

    // 3. The Vector: The "meaning" of the text in numbers
    private double[] vector;

    // This is the CONSTRUCTOR: It’s how we "create" a new record
    public VectorRecord(String id, String text, double[] vector) {
        this.id = id;
        this.text = text;
        this.vector = vector;
    }

    // Getters: These allow our search engine to "look" at the data
    public double[] getVector() { return vector; }
    public String getText() { return text; }
}