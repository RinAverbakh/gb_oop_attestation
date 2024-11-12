import java.io.*;


public class FileOperationImpl implements FileOperations{
    @Override
    public void save(Notebook notebook, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(notebook);
        }
    }

    @Override
    public Notebook Load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Notebook) ois.readObject();
        }
    }
}
