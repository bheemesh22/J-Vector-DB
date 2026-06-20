public class Main {
    public static void main(String[] args) {
        System.out.println("=== Running J-Vector Database System ===");

        // 1. Initialize our database store
        VectorStore db = new VectorStore();

        // 2. Mock up some "Embedded Books" (Using 3-dimensional vectors for concept)
        // Dimensions: [Has Magic, Has Spaceships, Has History]
        double[] harryPotterVector = {0.9, 0.0, 0.1}; // High magic
        double[] starWarsVector    = {0.4, 0.9, 0.0}; // Medium magic (The Force), High spaceships
        double[] worldWar2Vector   = {0.0, 0.0, 0.9}; // High history

        // 3. Insert them into our database vault
        db.insert(new VectorRecord("book_01", "Harry Potter and the Sorcerer's Stone", harryPotterVector));
        db.insert(new VectorRecord("book_02", "Star Wars: A New Hope Novelization", starWarsVector));
        db.insert(new VectorRecord("book_03", "The Rise and Fall of the Second World War", worldWar2Vector));

        System.out.println("Database populated with 3 records.");

        // 4. SIMULATE A USER QUERY
        // The user searches for: "A space adventure with laser battles"
        // The AI model converts user query into this vector:
        double[] userQueryVector = {0.1, 0.85, 0.0}; // High spaceships intent

        System.out.println("\nSearching database for meaning close to: 'Space adventure'...");
        VectorRecord result = db.searchNearestNeighbor(userQueryVector);

        // 5. Output the result
        if (result != null) {
            System.out.println("MATCH FOUND!");
            System.out.println("Book ID: " + result.getId());
            System.out.println("Book Title: " + result.getText());
        } else {
            System.out.println("No match found.");
        }
    }
}