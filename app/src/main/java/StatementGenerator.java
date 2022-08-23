import java.util.ArrayList;

public class StatementGenerator {
    private DataBase database;

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

//    private ArrayList<TransactionForStatement> addCalculatedBalance(ArrayList<Transaction> input ){
//
//        //Recorrer input<Transaction> y copiar uno a uno los valores a una lista de TransactionForStatement
//
//        /*
//            for each transaction of input list:
//             crear transactionForStatement
//             copiar [transaction] >> [transactionForStatement]
//             calcular balance >> [ transactionforStatement]
//        */
//
//    }
}
