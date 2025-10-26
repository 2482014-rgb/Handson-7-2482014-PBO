public class AccessModifiersPractice {
    public static void main(String[] args) {
        System.out.println("=== MASALAH DENGAN PUBLIC VARIABLES ===");

        // Latihan 1: Demonstrasi masalah public variables
        BadExample bad = new BadExample("John", 25, 5000, "john@example.com");
        bad.showInfo();

        // Data dapat diubah dari luar tanpa kontrol!
        bad.age = -100;
        bad.salary = -5000;
        bad.email = "bukanemail";
        System.out.println("\nSetelah data dirusak dari luar:");
        bad.showInfo();

        System.out.println("\n=== ENCAPSULATION SOLUTION ===");

        // Latihan 2: Demonstrasi encapsulation
        GoodExample good = new GoodExample("Jane", 30, 8000, "jane@example.com");
        good.showInfo();

        // Coba ubah data dengan setter valid dan tidak valid
        good.setAge(70);   // Tidak valid
        good.setSalary(-1000); // Tidak valid
        good.setEmail("salah-format");
        good.showInfo();

        System.out.println("\n=== ACCESS MODIFIER COMBINATIONS ===");

        AccessModifierDemo demo = new AccessModifierDemo();
        demo.publicMethod();  // Bisa
        demo.defaultMethod(); // Bisa karena dalam satu package
        demo.protectedMethod(); // Bisa
        // demo.privateMethod(); // ❌ Tidak bisa (private)

        System.out.println("\n=== GETTER/SETTER BEST PRACTICES ===");

        BankAccountSecure account = new BankAccountSecure("123456", 10000, "1234");
        account.deposit(2000);
        account.checkBalance("1234");
        account.withdraw(5000, "1234");
        account.checkBalance("1234");
        account.changePin("1234", "5678");
    }
}
