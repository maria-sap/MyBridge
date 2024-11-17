package src;
import java.util.HashMap;
import java.util.Scanner;

public class RegisterAndLogin {

    private static final HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Game System!");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1/2/3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                registerUser(scanner);
            } else if (choice == 2) {
                if (loginUser(scanner)) {
                    System.out.println("You are now logged in. Exiting the system.");
                    break; // Exit the loop after a successful login
                }
            } else if (choice == 3) {
                System.out.println("Exiting the system. Goodbye!");
                break; // Exit the loop if the user chooses to quit
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        userDatabase.put(username, password);
        System.out.println("Registration successful!");
    }

    private static boolean loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!userDatabase.containsKey(username)) {
            System.out.println("Username does not exist!");
            return false; // Return false to indicate failed login
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (password.equals(userDatabase.get(username))) {
            System.out.println("Login successful!");
            return true; // Return true to indicate successful login
        } else {
            System.out.println("Invalid password.");
            return false; // Return false for invalid password
        }
    }
}
