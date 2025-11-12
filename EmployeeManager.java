import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Business logic for employee operations.
 */
public class EmployeeManager {
    private final List<Employee> employees;

    public EmployeeManager(List<Employee> initial) {
        this.employees = new ArrayList<>(initial);
    }

    public boolean addEmployee(Employee emp) {
        if (findById(emp.getId()).isPresent()) return false;
        employees.add(emp);
        return true;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }

    public Optional<Employee> findById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    public boolean updateEmployee(int id, String newName, String newRole, double newSalary) {
        Optional<Employee> opt = findById(id);
        if (opt.isEmpty()) return false;
        Employee e = opt.get();
        if (newName != null && !newName.isBlank()) e.setName(newName);
        if (newRole != null && !newRole.isBlank()) e.setRole(newRole);
        if (newSalary >= 0) e.setSalary(newSalary);
        return true;
    }

    public boolean deleteById(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    public List<Employee> searchByName(String query) {
        String q = query.toLowerCase().trim();
        List<Employee> res = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(q) || e.getRole().toLowerCase().contains(q)) res.add(e);
        }
        return res;
    }
}
