import java.util.List;

/**
 * Industry-level abstraction layer for database persistence.
 * Allows switching between Binary, JSON, or Cloud storage without breaking the core engine.
 */
public interface StorageEngine {
    void save(List<VectorRecord> records) throws Exception;
    List<VectorRecord> load() throws Exception;
}