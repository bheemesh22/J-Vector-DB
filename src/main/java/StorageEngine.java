import java.util.List;


public interface StorageEngine {
    void save(List<VectorRecord> records) throws Exception;
    List<VectorRecord> load() throws Exception;
}