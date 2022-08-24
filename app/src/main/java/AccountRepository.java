import java.util.ArrayList;

public class AccountRepository {

    private final DataBase database;

    public AccountRepository() {

        this.database = new DataBase();
    }

    public void save(String timeStamp, Integer amount){

        database.data.add(new Transaction(timeStamp, amount));
    }

    public ArrayList<Transaction> findAll(){

        return database.data;
    }
}
