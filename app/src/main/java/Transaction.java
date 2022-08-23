public class Transaction {
    private String timestamp;
    private Integer amount;

    public Transaction(String timestamp, Integer amount) {
        this.timestamp = timestamp;
        this.amount = amount;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public Integer getAmount(){
        return amount;
    }
}
