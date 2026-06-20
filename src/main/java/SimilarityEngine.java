public class SimilarityEngine {

    /**
     * Calculates the Cosine Similarity between two multi-dimensional vectors.
     * Formula: (A . B) / (||A|| * ||B||)
     */
    public static double calculateCosineSimilarity(double[] vectorA, double[] vectorB) {
        // Edge Case Protection: If arrays are empty or mismatched, return 0
        if (vectorA == null || vectorB == null || vectorA.length != vectorB.length) {
            return 0.0;
        }

        double dotProduct = 0.0;
        double magnitudeASquared = 0.0;
        double magnitudeBSquared = 0.0;

        // The Core Loop: Processing the coordinates side-by-side
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];          // A_i * B_i
            magnitudeASquared += vectorA[i] * vectorA[i];    // A_i^2
            magnitudeBSquared += vectorB[i] * vectorB[i];    // B_i^2
        }

        // Edge Case Protection: Prevent division by zero if a vector is completely empty
        if (magnitudeASquared == 0.0 || magnitudeBSquared == 0.0) {
            return 0.0;
        }

        // Final Math Step
        double magnitudeA = Math.sqrt(magnitudeASquared);
        double magnitudeB = Math.sqrt(magnitudeBSquared);

        return dotProduct / (magnitudeA * magnitudeB);
    }
}