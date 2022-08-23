import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class DataBaseTest {
    @Test
    void when_adding_an_element_to_hashmap_then_return_element(){
        DataBase database = new DataBase();
        database.data.put("timestamp", 100);
        Integer actualResult = database.data.size();
        Integer expectedResult = 1;
        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}

