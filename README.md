# 📊 Professional Java Expense Tracker (CLI)

A robust backend-focused financial management system developed in **Java** with **SQLite** integration. This project demonstrates industry-standard practices in Object-Oriented Programming (OOP), database persistence, and financial data analytics.

## 🚀 Key Features
- **Full CRUD Operations:** Create, Read, Update, and Delete expense records with persistent storage.
- **SQL-Driven Analytics:** Real-time spending breakdowns using SQL `GROUP BY` and `SUM` aggregations.
- **Budget Monitoring Engine:** Automated validation logic that compares current spending against user-defined monthly limits.
- **Reliable Persistence:** Integrated with **SQLite via JDBC** to ensure data is saved even after the application closes.

## 🛠️ Technical Stack
- **Language:** Java (JDK 17+)
- **Database:** SQLite (Relational Database)
- **Driver:** JDBC (Java Database Connectivity)
- **Version Control:** Git & GitHub

## 🏗️ Architecture
This project follows a **Service-Oriented Architecture (SOA)**:
- **Model:** Encapsulated data objects (Expense, User).
- **Service Layer:** Business logic and SQL execution (ExpenseServiceImpl).
- **Utility:** Database connection management (DBConnection).
- **Main/UI:** CLI-based user interaction loop.

## 📉 Learning Outcomes
Developed to bridge the gap between academic theory and industry application:
1. **Security:** Prevented SQL Injection vulnerabilities using `PreparedStatement`.
2. **Clean Code:** Implemented Interfaces to ensure loose coupling and scalability.
3. **Data Integrity:** Managed database connection lifecycles to prevent memory leaks.

## ⚙️ Setup & Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/tejasssolanki/Java-Expense-Tracker.git](https://github.com/tejasssolanki/Java-Expense-Tracker.git)
