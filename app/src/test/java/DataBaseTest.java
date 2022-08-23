import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataBaseTest {
    @Test
    void when_adding_an_element_to_list_then_return_element(){
        Integer expectedResult = 1;
        Assertions.assertThat(createActualResult()).isEqualTo(expectedResult);
    }

    private Integer createActualResult(){
        DataBase database = new DataBase();
        Transaction transaction = new Transaction("timestamp", 100);
        database.data.add(transaction);
        Integer actualResult = database.data.size();
        return actualResult;
    }
}

