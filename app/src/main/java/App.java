import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        StatementGenerator statementGenerator = new StatementGenerator(accountRepository.database);
        Account account = new Account(accountRepository);

        account.deposit(300);
        account.withdraw(100);
        account.deposit(300);

        System.out.println(statementGenerator.getStatement(statementGenerator.getData()));
    }
}