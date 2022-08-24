import java.util.ArrayList;

public class AccountRepository {

    private final DataBase database;

    public AccountRepository() {

        this.database = new DataBase();
    }

    public void save(Transaction transaction){

        database.data.add(transaction);
    }

    public ArrayList<Transaction> findAll(){

        return database.data;
    }
}
