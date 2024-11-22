package src;

import java.sql.*;
import java.util.Scanner;

//java -cp "classes;lib/sqlite-jdbc-3.36.0.3.jar" src.RegisterAndLogin to run the code

public class RegisterAndLogin {

    private static final String DATABASE_URL = "jdbc:sqlite:./db/users.db"; // Correct relative path

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Game System!");

        // Create the database and users table if it doesn't exist
        createDatabase();

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice (1/2/3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            if (choice == 1) {
                if (registerUser(scanner)) {
                    System.out.println("User registered successfully!");
                } else {
                    System.out.println("Registration failed.");
                }
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

    private static void createDatabase() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "username TEXT UNIQUE NOT NULL,"
                    + "password TEXT NOT NULL)";
            Statement stmt = connection.createStatement();
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    private static boolean registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userExists(username)) {
            System.out.println("Username already exists!");
            return false; // Indicate registration failed
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String insertSQL = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                System.out.println("Registration successful!");
                return true; // Indicate registration succeeded
            }
        } catch (SQLException e) {
            System.err.println("Error during registration: " + e.getMessage());
            return false; // Indicate registration failed
        }
    }

    private static boolean userExists(String username) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String selectSQL = "SELECT 1 FROM users WHERE username = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error checking if user exists: " + e.getMessage());
            return false;
        }
    }

    private static boolean loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!userExists(username)) {
            System.out.println("Username does not exist!");
            return false;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String selectSQL = "SELECT password FROM users WHERE username = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
                pstmt.setString(1, username);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next() && rs.getString("password").equals(password)) {
                    System.out.println("Login successful!");
                    return true; // Successful login
                } else {
                    System.out.println("Invalid password.");
                    return false; // Invalid password
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return false;
        }
    }
}