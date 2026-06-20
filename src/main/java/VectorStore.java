import java.util.ArrayList;
import java.util.List;

public class VectorStore {
    private final List<VectorRecord> storage = new ArrayList<>();
    private StorageEngine storageEngine; // The abstract persistence layer

    // Dependency Injection via Constructor - Top 1% Practice
    public VectorStore(StorageEngine storageEngine) {
        this.storageEngine = storageEngine;
    }

    // Overloaded constructor for our current in-memory testing
    public VectorStore() {
        this.storageEngine = null;
    }

    public void insert(VectorRecord record) {
        storage.add(record);
    }

    public VectorRecord searchNearestNeighbor(double[] queryVector) {
        if (storage.isEmpty()) return null;

        VectorRecord bestMatch = null;
        double highestSimilarity = -1.0;

        for (VectorRecord record : storage) {
            double currentScore = SimilarityEngine.calculateCosineSimilarity(queryVector, record.getVector());
            if (currentScore > highestSimilarity) {
                highestSimilarity = currentScore;
                bestMatch = record;
            }
        }
        return bestMatch;
    }
}