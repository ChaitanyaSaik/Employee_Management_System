import java.util.Scanner;

/**
 * Simple input helpers to validate int/double and read lines safely.
 */
public class InputUtil {
    private final Scanner sc;

    public InputUtil(Scanner sc) {
        this.sc = sc;
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine().trim();
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}
