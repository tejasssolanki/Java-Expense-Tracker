/**
 * Description: Core business logic engine. Implemented using JDBC to interact
 * with a SQLite database. Handles data processing, SQL execution, and
 * analytical calculations.
 */
package expensetracker.service;
import java.sql.Statement;
import java.sql.ResultSet;
import expensetracker.model.Expense;
import expensetracker.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public void addExpense(Expense expense) {
        String sql = "INSERT INTO expenses(amount, category, description, date) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, expense.getAmount());
            pstmt.setString(2, expense.getCategory());
            pstmt.setString(3, expense.getDescription());
            pstmt.setString(4, expense.getDate());

            pstmt.executeUpdate();
            System.out.println("✅ Saved to Database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewExpenses()
    {
        String sql = "SELECT * FROM expenses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Your Saved Expenses ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Amount: $" + rs.getDouble("amount") +
                        " | Category: " + rs.getString("category") +
                        " | Date: " + rs.getString("date"));
            }
            System.out.println("---------------------------\n");

        } catch (SQLException e) {
            System.out.println("❌ Error reading data: " + e.getMessage());
        }
    }

    @Override
    public void calculateTotal() { }

    @Override
    public void deleteExpense() { }

    @Override
    public void calculateTotalAndCheckBudget(double monthlyBudget) {
        String sql = "SELECT SUM(amount) as total FROM expenses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                double totalSpent = rs.getDouble("total");
                System.out.println("\n===== 💰 BUDGET REPORT =====");
                System.out.println("Total Spent: $" + totalSpent);
                System.out.println("Budget Limit: $" + monthlyBudget);

                if (totalSpent > monthlyBudget) {
                    System.out.println("⚠️ ALERT: Over budget by $" + (totalSpent - monthlyBudget));
                } else {
                    System.out.println("✅ Within budget! Remaining: $" + (monthlyBudget - totalSpent));
                }
                System.out.println("===========================\n");
            }
        } catch (SQLException e) {
            System.out.println("❌ Budget Error: " + e.getMessage());
        }
    }

    @Override
    public void viewCategoryBreakdown() {
        String sql = "SELECT category, SUM(amount) as cat_total FROM expenses GROUP BY category";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- 📊 CATEGORY ANALYSIS ---");
            while (rs.next()) {
                System.out.println("🔹 " + rs.getString("category") + ": $" + rs.getDouble("cat_total"));
            }
            System.out.println("----------------------------\n");
        } catch (SQLException e) {
            System.out.println("❌ Analytics Error: " + e.getMessage());
        }
    }
    @Override
    public void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Expense with ID " + id + " deleted successfully!");
            } else {
                System.out.println("⚠️ No expense found with ID " + id);
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete Error: " + e.getMessage());
        }
    }
    public void displayCategoryAnalytics() {
        // This SQL query calculates the sum per category and the total overall
        String query = "SELECT category, SUM(amount) as total_cat, " +
                "(SELECT SUM(amount) FROM expenses) as grand_total " +
                "FROM expenses GROUP BY category";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- 📊 FINANCIAL ANALYTICS REPORT ---");
            while (rs.next()) {
                String category = rs.getString("category");
                double catTotal = rs.getDouble("total_cat");
                double grandTotal = rs.getDouble("grand_total");
                double percentage = (catTotal / grandTotal) * 100;

                // Visual Bar Chart Logic
                int barWidth = (int) (percentage / 5); // 1 block per 5%
                String bar = "█".repeat(Math.max(0, barWidth));

                System.out.printf("%-12s: ₹%-8.2f [%-20s] %.1f%%\n",
                        category, catTotal, bar, percentage);
            }
            System.out.println("---------------------------------------\n");

        } catch (SQLException e) {
            System.out.println("Error generating analytics: " + e.getMessage());
        }
    }
}