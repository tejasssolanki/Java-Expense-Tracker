📊 Java Expense Insight Engine (v2.0)
A sophisticated financial management system built with Java 17 and SQLite, designed for efficient data persistence and real-time analytics. This project demonstrates professional-grade Java development, moving beyond basic console apps to a structured, database-driven solution.

🏗️ Project Structure & Architecture
The project follows a Modular Service-Oriented Architecture to ensure the code is maintainable, readable, and scalable.

models/: Contains the Expense POJO (Plain Old Java Object) representing the core data entity.

services/: Houses the business logic. I used Java Interfaces to decouple the service definition from its implementation (ExpenseServiceImpl), following the Dependency Inversion Principle.

utilities/: Manages the DBConnection using a centralized approach to ensure efficient database access.

lib/: Manages external dependencies, specifically the SQLite JDBC Driver.

💾 Why SQLite?
I chose SQLite over simple file-based storage (like .txt or .csv) to implement industry-standard data management:

Relational Integrity: Enforces data types and structure, ensuring every expense record is consistent.

Advanced Querying: Powered the Analytics Engine by performing calculations (like SUM and GROUP BY) directly in the database layer for better performance.

Portability: As a file-based database, the expenses.db stays with the project, making it "zero-config" and easily portable across different machines.

JDBC Mastery: Provided a real-world use case for Java Database Connectivity, a core requirement for enterprise Java roles.

🔄 Data Flow
How information moves through this system:

User Interface: The Main class captures user input via the CLI menu.

Service Layer: Data is processed and validated in the Service Implementation.

Persistence Layer: The service communicates with the SQLite database using PreparedStatements to prevent SQL Injection.

Data Retrieval: SQL ResultSets are mapped back into Java Objects for a seamless user experience.

🎓 Key Learnings & Engineering Growth
Building this system provided hands-on experience with:

Professional Git Workflow: Successfully managed repository cleanliness by mastering .gitignore and Git cache management.

Security Best Practices: Implemented parameterized queries to ensure the application is secure against common database attacks.

Data Visualization: Created a custom CLI logic to transform raw SQL data into visual ASCII bar charts for better UX.

SOLID Principles: Applied abstraction through interfaces, making the codebase "Open for Extension but Closed for Modification."

🚀 How to Run
Ensure you have the sqlite-jdbc jar in your /lib folder.

Compile: javac -cp "lib/*" -d out src/**/*.java

Run: java -cp "out;lib/*" com.expensetracker.main.Main
