import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Transaction {
    private String transactionId;
    private String type;
    private double amount;
    private String timestamp;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.transactionId = generateTransactionId();
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.description = description;
    }

    private String generateTransactionId() {
        Random rand = new Random();
        return "TX" + (100000 + rand.nextInt(900000));
    }

    @Override
    public String toString() {
        return transactionId + " | " + timestamp + " | " + type + " | Rp" + amount + " | " + description;
    }
}
