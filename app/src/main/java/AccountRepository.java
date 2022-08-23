import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountRepository {

    private final DataBase database;

    public AccountRepository() {
        this.database = new DataBase();
    }

    public String createTimestamp(){
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy.HH:mm:ss");
        String timeStamp = date.format(new Date());
        return timeStamp;
    }

    public void save(){
        database.data.put(createTimestamp(), 100);
    }

    public ArrayList<Transaction> findAll(){
        ArrayList<Transaction> transactionHistory = new ArrayList<>();
        return transactionHistory;
    }
}
