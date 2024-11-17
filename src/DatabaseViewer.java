package src;
import java.sql.*;

public class DatabaseViewer {

    private static final String DATABASE_URL = "jdbc:sqlite:users.db"; // Path to the SQLite database file

    public static void main(String[] args) {
        displayUsers(); // Call method to display users in the database
    }

    private static void displayUsers() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String selectSQL = "SELECT * FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + " | Password: " + password);
            }

        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
