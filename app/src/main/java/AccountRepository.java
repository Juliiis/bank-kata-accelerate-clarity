import java.util.ArrayList;

public interface AccountRepository {
    void save(Transaction transaction);
    ArrayList<Transaction> findAll();
}
