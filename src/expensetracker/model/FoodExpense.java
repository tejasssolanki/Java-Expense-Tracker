package expensetracker.model;

public class FoodExpense extends Expense {
    public FoodExpense(int expenseId, int userId, double amount, String date, String description) {
        super(expenseId, userId, amount, date, description);
    }

    @Override
    public String getCategory() {
        return "Food";
    }
}
