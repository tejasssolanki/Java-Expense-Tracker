# 📊 Java Expense Insight Engine (v2.0)

A sophisticated financial management system built with **Java 17** and **SQLite**. This version introduces a **SQL-driven Analytics Engine** that provides visual spending breakdowns directly in the CLI.

## 🌟 New Feature: Advanced Analytics
- **SQL Aggregation:** Uses complex `GROUP BY` and `SUM` queries to calculate spending percentages at the database level.
- **ASCII Data Visualization:** Generates dynamic bar charts in the terminal to visualize category-wise budget distribution.
- **Real-time Processing:** Calculations are performed on-the-fly, ensuring the dashboard is always up-to-date.



## 🛠️ Technical Excellence
- **Architecture:** Implemented using **Interfaces** to ensure loose coupling (SOLID Principles).
- **Persistence:** High-performance data storage using **SQLite JDBC**.
- **Security:** Strict use of **PreparedStatements** to mitigate SQL Injection risks.
- **Clean Code:** 100% separation of concerns between Model, Service, and Utility layers.

## 🚀 How to Run
1. Ensure you have the `sqlite-jdbc` jar in your `/lib` folder.
2. Compile: `javac -cp "lib/*" -d out src/expensetracker/**/*.java`
3. Run: `java -cp "out;lib/*" expensetracker.main.Main`

## 📈 Learning Journey
By building this, I mastered:
1. **Relational Database Design:** Creating efficient schemas for financial data.
2. **Advanced Java Logic:** Managing complex loops and formatting for CLI UI/UX.
3. **Version Control:** Professional Git workflow, including `.gitignore` management and remote synchronization.
