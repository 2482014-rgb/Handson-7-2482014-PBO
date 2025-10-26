public class BankAccountSecure {
    private String accountNumber;
    private double balance;
    private String pin;
    private boolean isLocked = false;

    public BankAccountSecure(String accountNumber, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (isValidAmount(amount)) {
            balance += amount;
            System.out.println("✅ Deposit berhasil. Saldo sekarang: " + balance);
        } else {
            System.out.println("❌ Jumlah tidak valid.");
        }
    }

    public void withdraw(double amount, String inputPin) {
        if (!validatePin(inputPin)) {
            System.out.println("❌ PIN salah. Akun dikunci.");
            lockAccount();
            return;
        }
        if (amount <= balance && amount > 0 && !isLocked) {
            balance -= amount;
            System.out.println("✅ Penarikan berhasil. Sisa saldo: " + balance);
        } else {
            System.out.println("❌ Penarikan gagal.");
        }
    }

    public void checkBalance(String inputPin) {
        if (validatePin(inputPin) && !isLocked) {
            System.out.println("💰 Saldo Anda: " + balance);
        } else {
            System.out.println("❌ Tidak dapat menampilkan saldo. PIN salah atau akun terkunci.");
        }
    }

    public void changePin(String oldPin, String newPin) {
        if (validatePin(oldPin)) {
            this.pin = newPin;
            System.out.println("✅ PIN berhasil diubah.");
        } else {
            System.out.println("❌ PIN lama salah.");
        }
    }

    private boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    private void lockAccount() {
        this.isLocked = true;
        System.out.println("🔒 Akun telah dikunci!");
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public String getAccountStatus() {
        return isLocked ? "Locked" : "Active";
    }
}

