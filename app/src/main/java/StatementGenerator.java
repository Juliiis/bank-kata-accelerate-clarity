import java.util.ArrayList;

public class StatementGenerator {
    private final DataBase database;

    public StatementGenerator(DataBase database){

        this.database = database;
    }

    public ArrayList<TransactionForStatement> getData(){

        ArrayList<Transaction> inputList = database.data;
        ArrayList<TransactionForStatement> outputList = new ArrayList<>();
        Integer balance = 0;
        for (Transaction transaction:inputList) {
            balance += transaction.getAmount();
            outputList.add(new TransactionForStatement(transaction.getTimestamp(), transaction.getAmount(), balance));
        }
        return outputList;
    }

    public ArrayList<ArrayList<String>> getStatement(ArrayList<TransactionForStatement> transactionList) {
        ArrayList<ArrayList<String>> outputTable = new ArrayList<>();
        ArrayList<String> innerList = new ArrayList<>();
        innerList.add("Date");
        innerList.add("Amount");
        innerList.add("Balance");
        outputTable.add(innerList);

        for(TransactionForStatement transaction : transactionList) {
            ArrayList<String> innerElementList = new ArrayList<>();
            innerElementList.add(transaction.getTimestamp());
            innerElementList.add(transaction.getAmount().toString());
            innerElementList.add(transaction.getBalance().toString());
            outputTable.add(innerElementList);
        }
        
        return outputTable;
    }
}
