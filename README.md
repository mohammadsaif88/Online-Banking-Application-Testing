# Online-Banking-Application-Testing
Designed and executed a comprehensive testing project for an online banking portal simulation where users can log in, transfer funds, check balance, and view transaction history. Focused on validating both functional and negative scenarios through manual and automation testing.

Key Contributions:

Developed and executed manual test cases for login, fund transfers, balance inquiry, and mini-statement.

Built automation test scripts using Selenium WebDriver with Java to handle multi-page login authentication (username + OTP) and fund transfer workflows.

Applied Page Object Model (POM) to ensure code reusability and maintainability.

Validated backend operations using SQL queries to confirm account balance updates and transaction logs.

Implemented negative test cases such as insufficient balance transfers to ensure application robustness.

Enhanced automation coverage with data-driven testing by fetching multiple test inputs from Excel/CSV.

Skills & Tools: Selenium WebDriver, Core Java, TestNG, SQL, POM Framework, Excel/CSV, Eclipse, Git.

How to run (README instructions)

1.Ensure you have Java 11+, Maven, Chrome browser, and ChromeDriver on PATH.

2.Serve the app folder on a simple HTTP server. From the project root run:
cd online-banking-test
python -m http.server 8000

3.In another terminal, run:
mvn test

4.Tests use TestNG and H2 in-memory DB; CSV test data lives in data/transfer_data.csv.
