import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountRepository {

    private final DataBase database;

    public AccountRepository() {
        this.database = new DataBase();
    }

    public Transaction createTransaction(String timeStamp, Integer amount) {
        Transaction transaction = new Transaction(timeStamp, amount);
        return transaction;
    }

    public void save(String timeStamp, Integer amount){
        database.data.add(createTransaction(timeStamp, amount));
    }

    public ArrayList<Transaction> findAll(){
        return database.data;
    }
}
