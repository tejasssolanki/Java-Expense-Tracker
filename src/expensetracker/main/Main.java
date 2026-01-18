/**
 * Project: Personal Expense Tracker (Java & SQLite)
 * Author: Tejas Solanki
 * Description: Entry point of the application. Manages the Command Line Interface (CLI),
 * user interaction, and orchestrates the service layer to perform financial operations.
 */
package expensetracker.main;

import expensetracker.model.FoodExpense;
import expensetracker.model.TravelExpense;
import expensetracker.service.ExpenseService;
import expensetracker.service.ExpenseServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseService service = new ExpenseServiceImpl();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("🚀 Expense Tracker System Active");

        // Main application loop to keep the program active until the user exits.
        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. ➕ Add New Expense");
            System.out.println("2. 📄 View All Expenses");
            System.out.println("3. 📊 View Category Breakdown");
            System.out.println("4. 💰 Check Budget Status");
            System.out.println("5. 🗑️ Delete Expense");
            System.out.println("6. ❌ Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            // Consume newline character to prevent Scanner skipping input (common Java bug).
            sc.nextLine();

            switch (choice) {
                // Directing user request to the specific service implementation.
                case 1:
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Category (Food/Travel): ");
                    String cat = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    if (cat.equalsIgnoreCase("Food")) {
                        service.addExpense(new FoodExpense(0, 1, amt, date, desc));
                    } else {
                        service.addExpense(new TravelExpense(0, 1, amt, date, desc));
                    }
                    break;

                case 2:
                    service.viewExpenses();
                    break;

                case 3:
                    service.viewCategoryBreakdown();
                    break;

                case 4:
                    System.out.print("Enter your monthly budget limit: ");
                    double limit = sc.nextDouble();
                    service.calculateTotalAndCheckBudget(limit);
                    break;

                case 5:
                    System.out.print("Enter the ID of the expense to delete: ");
                    int idToDelete = sc.nextInt();
                    service.deleteExpense(idToDelete);
                    break;
                case 6:
                    running = false;
                    System.out.println("Data saved. Closing Expense Tracker...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}