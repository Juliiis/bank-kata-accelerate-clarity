public class Account {

    private final AccountRepository accountRepository;

    public Account(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    void deposit(int amount){

    }

    void withdraw(int amount){

    }

    String printStatement(StatementGenerator statementGenerator){
        return "";
    }

}
