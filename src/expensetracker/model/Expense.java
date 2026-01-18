/**
 * Description: Base Data Model representing a generic expense.
 * Uses Encapsulation to protect data integrity.
 */
package expensetracker.model;

public abstract class Expense {
    private int expenseId;
    public int userId;
    private double amount;
    private String date;
    private String description;

    public Expense(int expenseId, int userId, double amount, String date, String description) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }
    public int getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
    @Override
    public String toString() {
        return String.format("#%d | %s | Amount: ₹%.2f | Date: %s | %s",
                getExpenseId(), getCategory(), getAmount(), getDate(), getDescription());
    }
    public abstract String getCategory();

}