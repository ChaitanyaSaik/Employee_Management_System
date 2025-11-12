import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles saving and loading employee list to a file using serialization.
 */
public class EmployeeStorage {
    private final String filename;

    public EmployeeStorage(String filename) {
        this.filename = filename;
    }

    public void save(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(new ArrayList<>(employees));
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Employee> load() {
        File f = new File(filename);
        if (!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Employee>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading data. Starting with empty list.");
            return new ArrayList<>();
        }
    }
}
