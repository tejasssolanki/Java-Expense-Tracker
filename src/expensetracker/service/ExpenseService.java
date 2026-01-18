/**
 * Description: Architectural contract for the Expense Tracker.
 * Defines the standard operations for data management and financial analytics,
 * ensuring loose coupling between the UI and Backend logic.
 */
package expensetracker.service;
import expensetracker.model.Expense;
public interface ExpenseService {

    void addExpense(Expense expense);
    void viewExpenses();
    void deleteExpense();
    void calculateTotal();
    void deleteExpense(int id);


    void calculateTotalAndCheckBudget(double monthlyBudget);
    void viewCategoryBreakdown();

}
