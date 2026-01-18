/**
 * Description: Singleton-style utility class for database connectivity.
 * Manages the SQLite JDBC driver loading and establishes the link to the local .db file.
 */
package expensetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:expenses.db";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);

        // THIS IS THE FIX: Create the table if it is missing
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS expenses (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "amount REAL, " +
                    "category TEXT, " +
                    "description TEXT, " +
                    "date TEXT)");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }

        return conn;
    }
}