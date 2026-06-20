import java.util.ArrayList;
import java.util.List;

public class VectorStore {
    // This List acts as our internal database table
    private final List<VectorRecord> storage = new ArrayList<>();

    // 1. INSERT OPERATION: Add a record to our vault
    public void insert(VectorRecord record) {
        storage.add(record);
    }

    // 2. SEARCH OPERATION: Scan everything and find the closest match
    public VectorRecord searchNearestNeighbor(double[] queryVector) {
        if (storage.isEmpty()) {
            return null; // Can't search an empty database
        }

        VectorRecord bestMatch = null;
        double highestSimilarity = -1.0; // Start at the lowest possible score

        // The Scan: Look at every single saved book one by one
        for (VectorRecord record : storage) {
            double currentScore = SimilarityEngine.calculateCosineSimilarity(queryVector, record.getVector());

            // If this book is closer than the best one we've seen so far, update it!
            if (currentScore > highestSimilarity) {
                highestSimilarity = currentScore;
                bestMatch = record;
            }
        }

        return bestMatch;
    }
}