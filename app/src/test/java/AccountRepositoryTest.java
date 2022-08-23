import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountRepositoryTest {

    @Test
    void check_that_save_method_from_account_repository_works() {
        assertThat(createActualData()).usingRecursiveComparison().isEqualTo(createExpectedData());
    }

    private ArrayList<Transaction> createActualData() {
        AccountRepository accountRepository = new AccountRepository();
        accountRepository.save("hora", 100);
        ArrayList<Transaction> actualData = accountRepository.findAll();
        return actualData;
    }

    private ArrayList<Transaction> createExpectedData() {
        ArrayList<Transaction> expectedData = new ArrayList<>();
        Transaction transaction = new Transaction("hora", 100);
        expectedData.add(transaction);
        return expectedData;
    }

    @Test
    void check_that_find_all_method_from_account_repository_works(){
        AccountRepository accountRepository = new AccountRepository();
        accountRepository.save("22-03-2022", 100);
        ArrayList<Transaction> actualList = accountRepository.findAll();
        ArrayList<Transaction> expectedList = new ArrayList<>();
        Transaction transaction = new Transaction("22-03-2022", 100);
        expectedList.add(transaction);
        assertThat(actualList).usingRecursiveComparison().isEqualTo(expectedList);
    }
}
