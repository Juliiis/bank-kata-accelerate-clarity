import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InMemoryDatabaseTest {

    @Test
    void when_adding_an_element_to_list_then_return_element(){
        Integer expectedResult = 1;
        Assertions.assertThat(createActualResult()).isEqualTo(expectedResult);
    }

    private Integer createActualResult(){
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        Transaction transaction = new Transaction("timestamp", 100);
        inMemoryDatabase.save(transaction);
        Integer actualResult = inMemoryDatabase.findAll().size();
        return actualResult;
    }

    @Test
    void check_that_save_and_find_all_methods_from_account_repository_works() {

        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        Transaction transaction = new Transaction("22.03.2022", 100);
        inMemoryDatabase.save(transaction);
        ArrayList<Transaction> actualTransactionList;
        ArrayList<Transaction> expectedTransactionList = new ArrayList<>();
        expectedTransactionList.add(transaction);

        actualTransactionList = inMemoryDatabase.findAll();

        assertThat(actualTransactionList).usingRecursiveComparison().isEqualTo(expectedTransactionList);

    }
}
