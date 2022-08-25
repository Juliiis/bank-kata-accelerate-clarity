import java.util.ArrayList;

public class InMemoryDatabase implements AccountRepository {

    private final ArrayList<Transaction> data = new ArrayList<>();

    @Override
    public void save(Transaction transaction) {
        data.add(transaction);
    }

    @Override
    public ArrayList<Transaction> findAll() {
        return data;
    }
}
