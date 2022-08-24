import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountRepositoryTest {

    @Test
    void check_that_save_and_find_all_methods_from_account_repository_works() {

        AccountRepository accountRepository = new AccountRepository();
        accountRepository.save("22-03-2022", 100);
        ArrayList<Transaction> actualTransactionList;
        Transaction transaction = new Transaction("22-03-2022", 100);
        ArrayList<Transaction> expectedTransactionList = new ArrayList<>();
        expectedTransactionList.add(transaction);

        actualTransactionList = accountRepository.findAll();

        assertThat(actualTransactionList).usingRecursiveComparison().isEqualTo(expectedTransactionList);

    }
}
