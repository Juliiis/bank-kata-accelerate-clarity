import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTest {

    @Test
    void check_that_deposit_method_works() {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account(accountRepository);
        account.deposit(100);
        ArrayList<Transaction> actualTransactionList = accountRepository.findAll();

        ArrayList<Transaction> expectedTransactionList = new ArrayList<>();
        Transaction transaction = new Transaction("04-07-2022", 100);
        expectedTransactionList.add(transaction);
        assertThat(actualTransactionList).usingRecursiveComparison().isEqualTo(expectedTransactionList);
    }
    
    @Test
    void check_that_withdraw_method_works() {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account(accountRepository);
        account.withdraw(50);
        ArrayList<Transaction> actualTransactionList = accountRepository.findAll();

        ArrayList<Transaction> expectedTransactionList = new ArrayList<>();
        Transaction transaction = new Transaction("05-07-2022", -50);
        expectedTransactionList.add(transaction);
        assertThat(actualTransactionList).usingRecursiveComparison().isEqualTo(expectedTransactionList);
    }

    @Test
    void check_that_print_statement_method_works() {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account(accountRepository);
        account.deposit(300);
        account.withdraw(100);
        account.deposit(300);
        StatementGenerator statementGenerator = new StatementGenerator(accountRepository.database);
        String actualOutputStatement = account.printStatement(statementGenerator);

        String expectedOutputStatement = "        Date      Amount     Balance\n  04-07-2022         300         300\n  05-07-2022        -100         200\n  04-07-2022         300         500\n";
        assertThat(actualOutputStatement).isEqualTo(expectedOutputStatement);
    }
}
