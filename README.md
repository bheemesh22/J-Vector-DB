# J-Vector Engine 🚀

A high-performance, low-latency Vector Database built completely from scratch in Java. Designed to enable ultra-fast semantic search, high-dimensional vector indexing, and zero-dependency mathematical kernels.

---

## 🛠️ The Architecture

J-Vector decouples memory storage from execution pipelines using clean engineering principles, making it an ideal engine for downstream AI pipelines like audio transcription search engines (e.g., TranscribeFlow).

           +---------------------------------------+
           |             Client API                |
           +---------------------------------------+
                               |
                               v
           +---------------------------------------+
           |      VectorStore (Memory Table)       |
           +---------------------------------------+
             /                                   \
            /                                     \
           v                                       v
+---------------------------=--+         +-----------------------------+
|      SimilarityEngine        |         |       StorageEngine         |
|  (Mathematical Cosine Core)  |         |     (Abstraction Layer)     |
+------------------------------+         +-----------------------------+

## ✨ Core Features

* **Custom Math Kernel:** Hand-written implementation of multi-dimensional **Cosine Similarity** without external linear algebra dependencies.
* **Production Safeguards:** Built-in $O(1)$ exception handling mechanisms preventing execution crashes due to dimension mismatch or division-by-zero errors.
* **Decoupled Persistence Blueprint:** Architected using **Dependency Injection** patterns via a core `StorageEngine` interface to cleanly isolate memory-mapping from physical disk I/O.
* **Deterministic Integrity:** Implements a strict, highly accurate Linear Scan ($O(N)$ time complexity) ensuring 100% ground-truth retrieval accuracy.

---

## 💻 Tech Stack

* **Language:** Java 21 (Optimized for robust garbage collection and low-overhead object memory models)
* **Build Tool:** Maven

---

## 🧠 Technical Deep-Dive: Math Mechanics

The mathematical core evaluates alignment vectors using the standard Cosine Similarity equation:

$$Similarity = \frac{A \cdot B}{||A|| \times ||B||}$$

```java
// Foundational code snippet from SimilarityEngine.java
for (int i = 0; i < vectorA.length; i++) {
    dotProduct += vectorA[i] * vectorB[i];          // Alignment vector computation
    magnitudeASquared += vectorA[i] * vectorA[i];    // L2 Vector Norm squared
    magnitudeBSquared += vectorB[i] * vectorB[i];
}

📈 Future Scalability Roadmap
Approximate Nearest Neighbor (ANN) Indexing: Transition from $O(N)$ brute-force arrays to an HNSW (Hierarchical Navigable Small World) Graph representation to achieve $O(\log N)$ search optimization.
Hardware Acceleration: Implement Vector API (SIMD operations) to compute floating-point equations directly on CPU registers concurrently.
Binary Persistence (Java NIO): Implement zero-copy byte buffers using raw file-channel streams for transactional durability.

🚀 Getting Started
Prerequisites
  Java Development Kit (JDK) 17 or higher
  Apache Maven

Installation
Clone the repository:

Bash
git clone [https://github.com/bheemesh22/J-Vector-DB.git]
Navigate to the directory and run the main application compilation:

Bash
mvn clean package
java -cp target/classes Main
