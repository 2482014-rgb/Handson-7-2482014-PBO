public class InstanceMembersPractice {
    public static void main(String[] args) {
        System.out.println("=== INSTANCE VARIABLES BASICS ===");

        // Membuat beberapa object BankAccount
        BankAccount acc1 = new BankAccount("Andre", "Tabungan", 1000000);
        BankAccount acc2 = new BankAccount("Bela", "Giro", 2500000);
        BankAccount acc3 = new BankAccount("Jelita", "Tabungan", 5000000);

        // Menampilkan saldo masing-masing
        acc1.displayBalance();
        acc2.displayBalance();
        acc3.displayBalance();

        // Melakukan transaksi
        acc1.deposit(500000);
        acc2.withdraw(1000000);
        acc3.deposit(2000000);

        System.out.println("\n=== INSTANCE METHODS ADVANCED ===");
        acc1.printStatement();
        acc2.printStatement();
        acc3.printStatement();

        System.out.println("\n=== OBJECT COLLABORATION ===");
        // Transfer antar akun
        acc3.transfer(acc1, 1000000);

        // Tampilkan saldo setelah transfer
        acc1.displayBalance();
        acc3.displayBalance();

        // Buat customer yang punya banyak akun
        Customer cust1 = new Customer("C001", "Andi", "08123456789", "andi@example.com");
        cust1.addAccount(acc1);
        cust1.addAccount(acc2);

        cust1.displayAllAccounts();
    }
}
