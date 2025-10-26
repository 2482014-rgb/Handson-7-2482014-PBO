import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private boolean isActive;
    private List<Transaction> transactionHistory;

    // Constructor utama
    public BankAccount(String holderName, String accountType, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolderName = holderName;
        this.accountType = accountType;
        this.balance = initialBalance;
        this.isActive = true;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(new Transaction("OPEN", initialBalance, "Account opened"));
    }

    // Generate account number secara random
    private String generateAccountNumber() {
        Random rand = new Random();
        return "AC" + (100000 + rand.nextInt(900000));
    }

    // Deposit
    public void deposit(double amount) {
        if (isActive && amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("DEPOSIT", amount, "Setoran tunai"));
            System.out.println(accountHolderName + " deposit Rp" + amount);
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (!isActive) {
            System.out.println("Akun tidak aktif.");
            return;
        }
        if (amount <= balance && amount > 0) {
            balance -= amount;
            transactionHistory.add(new Transaction("WITHDRAW", amount, "Penarikan tunai"));
            System.out.println(accountHolderName + " tarik Rp" + amount);
        } else {
            System.out.println("Penarikan gagal. Saldo tidak cukup.");
        }
    }

    // Transfer ke akun lain
    public void transfer(BankAccount target, double amount) {
        if (amount <= balance && isActive && target.isActive) {
            this.withdraw(amount);
            target.deposit(amount);
            transactionHistory.add(new Transaction("TRANSFER", amount, "Transfer ke " + target.accountNumber));
            System.out.println("Transfer berhasil dari " + accountHolderName + " ke " + target.accountHolderName);
        } else {
            System.out.println("Transfer gagal.");
        }
    }

    // Dapatkan saldo
    public double getBalance() {
        return balance;
    }

    // Tampilkan saldo
    public void displayBalance() {
        System.out.println(accountHolderName + " (" + accountNumber + ") - Saldo: Rp" + balance);
    }

    // Tampilkan mutasi
    public void printStatement() {
        System.out.println("\n=== MUTASI " + accountHolderName + " (" + accountNumber + ") ===");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    // Aktivasi akun
    public void activateAccount() {
        this.isActive = true;
    }

    // Nonaktifkan akun
    public void deactivateAccount() {
        this.isActive = false;
    }

    // Status akun
    public boolean isActive() {
        return isActive;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

