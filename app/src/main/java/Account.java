public class Account {

    private final AccountRepository accountRepository;
    private final StatementGenerator statementGenerator;

    public Account(AccountRepository accountRepository, StatementGenerator statementGenerator) {
        this.accountRepository = accountRepository;
        this.statementGenerator = statementGenerator;
    }

    void deposit(int amount){
        if (amount > 0) {
            Transaction transaction = new Transaction("04.07.2022", amount);
            accountRepository.save(transaction);
        }
        else {
            throw new RuntimeException("The amount must be a positive number.");
        }
    }

    void withdraw(int amount){
        if (amount > 0) {
            amount = -amount;
            Transaction transaction = new Transaction("05.07.2022", amount);
            accountRepository.save(transaction);
        }
        else {
            throw new RuntimeException("The amount must be a positive number.");
        }
    }

    String printStatement(){
        return statementGenerator.getStatement(statementGenerator.getData());
    }

}
