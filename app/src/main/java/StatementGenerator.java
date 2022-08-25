import java.util.ArrayList;

public class StatementGenerator {
    private final InMemoryDatabase inMemoryDatabase;

    public StatementGenerator(InMemoryDatabase inMemoryDatabase){
        this.inMemoryDatabase = inMemoryDatabase;
    }

    public ArrayList<TransactionForStatement> getData(){

        ArrayList<Transaction> inputList = inMemoryDatabase.findAll();
        ArrayList<TransactionForStatement> outputList = new ArrayList<>();
        Integer balance = 0;
        for (Transaction transaction:inputList) {
            balance += transaction.getAmount();
            outputList.add(new TransactionForStatement(transaction.getTimestamp(), transaction.getAmount(), balance));
        }
        return outputList;
    }

    public String getStatement(ArrayList<TransactionForStatement> transactionList) {
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

        StringBuilder output = new StringBuilder();
        for (ArrayList<String> row : outputTable) {
            for (String element : row) {
                    output.append(String.format("%12s", element));
            }
            output.append("\n");
        }
        return output.toString();
    }
}
