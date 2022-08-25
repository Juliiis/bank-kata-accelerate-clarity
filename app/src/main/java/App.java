public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        StatementGenerator statementGenerator = new StatementGenerator(inMemoryDatabase);
        Account account = new Account(inMemoryDatabase, statementGenerator);

        account.deposit(300);
        account.withdraw(100);
        account.deposit(300);

        System.out.print(account.printStatement());
    }
}