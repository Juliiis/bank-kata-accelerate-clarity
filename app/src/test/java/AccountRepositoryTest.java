import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.util.Date;

import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountRepositoryTest {

    @Test
    void save_method_from_account_repository_works() {
        AccountRepository accountRepository = new AccountRepository();
        accountRepository.save("hora", 100);
        ArrayList<Transaction> actualData = accountRepository.findAll();
        ArrayList<Transaction> expectedData = new ArrayList<>();
        Integer amount = 100;
        Transaction transaction = new Transaction("hora", 100);
        expectedData.add(transaction);
        assertThat(actualData).usingRecursiveComparison().isEqualTo(expectedData);
    }
}
