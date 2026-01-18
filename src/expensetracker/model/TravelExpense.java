package expensetracker.model;
public class TravelExpense extends Expense{
    public TravelExpense(int expenseId,int userId, double amount, String date, String description) {
        super(expenseId,userId, amount, date, description);
    }
    @Override
    public String getCategory() {
        return "Travel";
    }
}
