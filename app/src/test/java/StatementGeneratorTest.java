import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatementGeneratorTest {

    @Test
    void check_that_get_data_method_works() {
        assertThat(createActualResult()).usingRecursiveComparison().isEqualTo(createExpectedResult());
    }

    private ArrayList<TransactionForStatement> createActualResult() {
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        Transaction transaction1 = new Transaction("25.06.2022", 300);
        Transaction transaction2 = new Transaction("01.11.2022", -200);
        inMemoryDatabase.save(transaction1);
        inMemoryDatabase.save(transaction2);
        StatementGenerator statementGenerator = new StatementGenerator(inMemoryDatabase);
        ArrayList<TransactionForStatement> actualResult = statementGenerator.getData();
        return actualResult;
    }

    private ArrayList<TransactionForStatement> createExpectedResult() {
        ArrayList<TransactionForStatement> expectedResult = new ArrayList<>();
        TransactionForStatement transactionForStatement1 = new TransactionForStatement("25.06.2022", 300, 300);
        TransactionForStatement transactionForStatement2 = new TransactionForStatement("01.11.2022", -200, 100);
        expectedResult.add(transactionForStatement1);
        expectedResult.add(transactionForStatement2);
        return expectedResult;
    }
}
