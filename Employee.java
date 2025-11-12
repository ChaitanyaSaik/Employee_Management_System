import java.io.Serializable;

/**
 * Simple Employee model.
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String role;
    private double salary;

    public Employee(int id, String name, String role, double salary) {
        this.id = id;
        this.name = name.trim();
        this.role = role.trim();
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name.trim(); }
    public void setRole(String role) { this.role = role.trim(); }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Role: %s | Salary: %.2f", id, name, role, salary);
    }
}
