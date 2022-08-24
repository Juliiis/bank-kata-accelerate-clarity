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
}
