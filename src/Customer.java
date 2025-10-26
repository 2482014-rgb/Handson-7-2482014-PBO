import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String email;
    private List<BankAccount> accounts;

    public Customer(String customerId, String name, String phone, String email) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Akun " + account.getAccountNumber() + " ditambahkan ke customer " + name);
    }

    public void displayAllAccounts() {
        System.out.println("\n=== DAFTAR AKUN CUSTOMER: " + name + " ===");
        for (BankAccount acc : accounts) {
            acc.displayBalance();
        }
    }
}

