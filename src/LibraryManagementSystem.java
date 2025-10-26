import java.time.LocalDate;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");

        // Setup library
        Library library = new Library("Perpustakaan Kampus", 14, 3);

        // Tambahkan buku
        Book b1 = new Book("978-1111111111", "Belajar Java", "Andi Santoso", "TechPub", 2020, BookCategory.SCIENCE);
        Book b2 = new Book("978-2222222222", "Sejarah Nusantara", "Budi Raharjo", "HistoryPress", 2010, BookCategory.HISTORY);
        Book b3 = new Book("978-3333333333", "Novel Remaja", "Citra Dewi", "FictionHouse", 2018, BookCategory.FICTION);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // Registrasi member
        Member m1 = library.registerMember("M001", "Andi", "andi@mail.com", "08123456789", "Jl. Melati 1", MembershipType.STUDENT);
        Member m2 = library.registerMember("M002", "Siti", "siti@mail.com", "08129876543", "Jl. Kenanga 5", MembershipType.PUBLIC);

        // Pinjam buku
        library.borrowBook("M001", "978-1111111111"); // sukses
        library.borrowBook("M002", "978-1111111111"); // gagal, sudah dipinjam

        // Cek laporan
        library.generatePopularBooksReport();
        library.generateActiveMembersReport();

        // Kembalikan buku telat -> cek denda
        // simulate time: we won't manipulate system date; instead create a record and force return with lateDays
        // For demo, borrow then extend/return within code:
        library.returnBook("M001", "978-1111111111"); // return on time in demo

        // Display stats
        library.displayLibraryStats();

        // Backup
        library.backup();
    }
}
