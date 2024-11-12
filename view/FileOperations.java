import java.io.IOException;

public interface FileOperations {
    void save(Notebook notebook, String fileName) throws IOException;
    Notebook Load(String fileName) throws IOException, ClassNotFoundException; 
}
