public class Account {

    private final AccountRepository accountRepository;

    public Account(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void deposit(int amount){
        if (amount > 0) {
            Transaction transaction = new Transaction("04-07-2022", amount);
            accountRepository.save(transaction);
        }
        else {
            throw new RuntimeException("The amount must be a positive number.");
        }
    }

    void withdraw(int amount){
        if (amount > 0) {
            amount *= -1;
            Transaction transaction = new Transaction("05-07-2022", amount);
            accountRepository.save(transaction);
        }
        else {
            throw new RuntimeException("The amount must be a positive number.");
        }
    }

    String printStatement(StatementGenerator statementGenerator){
        return statementGenerator.getStatement(statementGenerator.getData());
    }

}
