import java.util.List;
import java.util.Scanner;

/**
 * Console UI and app entry point.
 */
public class Main {
    private static final String STORAGE_FILE = "employees.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputUtil input = new InputUtil(scanner);
        EmployeeStorage storage = new EmployeeStorage(STORAGE_FILE);
        EmployeeManager manager = new EmployeeManager(storage.load());

        boolean running = true;
        while (running) {
            printMenu();
            String choice = input.readLine("Enter choice: ");
            switch (choice) {
                case "1" -> handleAdd(input, manager);
                case "2" -> handleView(manager);
                case "3" -> handleSearch(input, manager);
                case "4" -> handleUpdate(input, manager);
                case "5" -> handleDelete(input, manager);
                case "6" -> {
                    storage.save(manager.getAll());
                    System.out.println("Data saved. Exiting.");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Employee Management ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee (by ID or name/role)");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Save & Exit");
    }

    private static void handleAdd(InputUtil input, EmployeeManager manager) {
        int id = input.readInt("Enter ID: ");
        if (manager.findById(id).isPresent()) {
            System.out.println("ID already exists. Use update if needed.");
            return;
        }
        String name = input.readLine("Enter Name: ");
        String role = input.readLine("Enter Role: ");
        double salary = input.readDouble("Enter Salary: ");
        Employee emp = new Employee(id, name, role, salary);
        boolean ok = manager.addEmployee(emp);
        System.out.println(ok ? "Employee added." : "Failed to add.");
    }

    private static void handleView(EmployeeManager manager) {
        List<Employee> all = manager.getAll();
        if (all.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("\n-- Employees --");
        all.forEach(e -> System.out.println(e.toString()));
    }

    private static void handleSearch(InputUtil input, EmployeeManager manager) {
        String token = input.readLine("Enter ID or name/role to search: ");
        try {
            int id = Integer.parseInt(token);
            manager.findById(id).ifPresentOrElse(
                e -> System.out.println("Found: " + e),
                () -> System.out.println("Not found by ID.")
            );
        } catch (NumberFormatException ex) {
            List<Employee> matches = manager.searchByName(token);
            if (matches.isEmpty()) System.out.println("No matches found.");
            else matches.forEach(e -> System.out.println(e));
        }
    }

    private static void handleUpdate(InputUtil input, EmployeeManager manager) {
        int id = input.readInt("Enter ID to update: ");
        if (manager.findById(id).isEmpty()) {
            System.out.println("ID not found.");
            return;
        }
        String newName = input.readLine("Enter new name (leave blank to keep): ");
        String newRole = input.readLine("Enter new role (leave blank to keep): ");
        String salaryStr = input.readLine("Enter new salary (leave blank to keep): ");
        double newSalary = -1;
        if (!salaryStr.isBlank()) {
            try { newSalary = Double.parseDouble(salaryStr); }
            catch (NumberFormatException e) { System.out.println("Invalid salary input. Update aborted."); return; }
        }
        boolean ok = manager.updateEmployee(id,
                newName.isBlank() ? null : newName,
                newRole.isBlank() ? null : newRole,
                newSalary);
        System.out.println(ok ? "Updated." : "Update failed.");
    }

    private static void handleDelete(InputUtil input, EmployeeManager manager) {
        int id = input.readInt("Enter ID to delete: ");
        boolean ok = manager.deleteById(id);
        System.out.println(ok ? "Deleted." : "No record deleted.");
    }
}
