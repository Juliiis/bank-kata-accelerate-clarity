public class App {

    public String getGreeting() {
        return "Hello World!";
    }
    public static void main(String[] args) {
        PostgresDatabase postgresDatabase = new PostgresDatabase();
        StatementGenerator statementGenerator = new StatementGenerator(postgresDatabase);
        Account account = new Account(postgresDatabase, statementGenerator);

        account.deposit(300);
        account.withdraw(100);
        account.deposit(300);

        System.out.print(account.printStatement());
    }
}
