import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<BorrowRecord> borrowRecords;

    private String libraryName;
    private final double FINE_PER_DAY = LibraryUtils.DEFAULT_FINE_PER_DAY;

    // library policies
    private int loanPeriodDays;
    private int maxBooksPerMember;

    public Library(String libraryName, int loanPeriodDays, int maxBooksPerMember) {
        this.libraryName = libraryName;
        this.loanPeriodDays = loanPeriodDays;
        this.maxBooksPerMember = maxBooksPerMember;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    // Book management
    public void addBook(Book book) {
        if (book == null) return;
        books.add(book);
        System.out.println("Buku ditambahkan: " + book.getTitle());
    }

    public boolean removeBook(String isbn) {
        Optional<Book> ob = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();
        if (ob.isPresent()) {
            books.remove(ob.get());
            System.out.println("Buku dihapus: " + isbn);
            return true;
        }
        return false;
    }

    public List<Book> searchBooks(String keyword) {
        String k = keyword == null ? "" : keyword.toLowerCase();
        return books.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(k) || b.getAuthor().toLowerCase().contains(k) || b.getIsbn().contains(k))
                .collect(Collectors.toList());
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    // Member management
    public Member registerMember(String memberId, String name, String email, String phone, String address, MembershipType type) {
        Member m = new Member(memberId, name, email, phone, address, type);
        members.add(m);
        System.out.println("Member terdaftar: " + memberId + " - " + name);
        return m;
    }

    public Member getMemberById(String memberId) {
        return members.stream().filter(m -> m.getMemberId().equals(memberId)).findFirst().orElse(null);
    }

    public List<Member> getActiveMembers() {
        return members.stream().filter(Member::isActive).collect(Collectors.toList());
    }

    // Borrowing methods
    public boolean borrowBook(String memberId, String isbn) {
        Member member = getMemberById(memberId);
        Book book = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
        if (member == null) {
            System.out.println("Member tidak ditemukan: " + memberId);
            return false;
        }
        if (book == null) {
            System.out.println("Buku tidak ditemukan: " + isbn);
            return false;
        }
        int currentlyBorrowed = (int) borrowRecords.stream().filter(r -> r.getMemberId().equals(memberId) && r.getReturnDate() == null).count();
        if (!member.canBorrowMore(currentlyBorrowed, maxBooksPerMember)) {
            System.out.println("Member tidak bisa meminjam lebih banyak buku: " + memberId);
            return false;
        }
        if (!book.isAvailable()) {
            System.out.println("Buku tidak tersedia: " + book.getTitle());
            return false;
        }
        // process borrow
        boolean ok = book.borrowBook();
        if (!ok) {
            System.out.println("Gagal meminjam buku.");
            return false;
        }
        BorrowRecord record = new BorrowRecord(memberId, isbn, loanPeriodDays);
        borrowRecords.add(record);
        System.out.println("Pinjam berhasil: " + memberId + " -> " + book.getTitle());
        return true;
    }

    public boolean returnBook(String memberId, String isbn) {
        // find active borrow record
        Optional<BorrowRecord> or = borrowRecords.stream()
                .filter(r -> r.getMemberId().equals(memberId) && r.getIsbn().equals(isbn) && r.getReturnDate() == null)
                .findFirst();
        if (!or.isPresent()) {
            System.out.println("Tidak ada record peminjaman aktif untuk member " + memberId + " dan buku " + isbn);
            return false;
        }
        BorrowRecord rec = or.get();
        rec.returnBook();
        // mark book available
        Book book = books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
        if (book != null) book.returnBook();

        if (rec.getFine() > 0) {
            System.out.println("Denda harus dibayar sebesar: Rp" + rec.getFine());
        } else {
            System.out.println("Pengembalian berhasil, tidak ada denda.");
        }
        return true;
    }

    public boolean extendLoan(String recordId, int extraDays) {
        Optional<BorrowRecord> or = borrowRecords.stream().filter(r -> r.getRecordId().equals(recordId) && r.getReturnDate() == null).findFirst();
        if (!or.isPresent()) return false;
        BorrowRecord rec = or.get();
        rec.extendLoan(extraDays);
        System.out.println("Perpanjangan berhasil untuk record " + recordId + " extra days: " + extraDays);
        return true;
    }

    public double calculateFine(String recordId) {
        Optional<BorrowRecord> or = borrowRecords.stream().filter(r -> r.getRecordId().equals(recordId)).findFirst();
        if (!or.isPresent()) return 0.0;
        return or.get().calculateFine();
    }

    // Reporting
    public void generatePopularBooksReport() {
        System.out.println("\n=== Popular Books Report ===");
        books.stream()
                .sorted(Comparator.comparingInt(Book::getBorrowCount).reversed())
                .limit(10)
                .forEach(Book::displayBookInfo);
    }

    public void generateActiveMembersReport() {
        System.out.println("\n=== Active Members Report ===");
        getActiveMembers().stream().limit(10).forEach(Member::displayMemberInfo);
    }

    public void generateOverdueReport() {
        System.out.println("\n=== Overdue Report ===");
        borrowRecords.stream().filter(BorrowRecord::isOverdue).forEach(r -> System.out.println(r));
    }

    // Utility
    public void displayLibraryStats() {
        System.out.println("\n=== Library Stats ===");
        System.out.println("Library: " + libraryName);
        System.out.println("Total Books: " + books.size());
        System.out.println("Total Members: " + members.size());
        System.out.println("Active Borrow Records: " + borrowRecords.stream().filter(r -> r.getReturnDate() == null).count());
    }

    public void backup() {
        // simple simulation of backup
        System.out.println("Backup data library...");
        System.out.println("Books: " + books.size() + ", Members: " + members.size() + ", Records: " + borrowRecords.size());
        System.out.println("Backup complete.");
    }

    public void maintenance() {
        // placeholder
        System.out.println("Running maintenance tasks...");
    }

    // Helpers
    private boolean isValidMember(String memberId) {
        return getMemberById(memberId) != null;
    }

    private boolean isBookAvailable(String isbn) {
        return books.stream().anyMatch(b -> b.getIsbn().equals(isbn) && b.isAvailable());
    }
}
