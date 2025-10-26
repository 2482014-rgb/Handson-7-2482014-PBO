import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BorrowRecord {
    private String recordId;
    private String memberId;
    private String isbn;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine; // computed at return
    private static int totalRecords = 0;

    public BorrowRecord(String memberId, String isbn, int loanPeriodDays) {
        this.recordId = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.isbn = isbn;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(loanPeriodDays);
        this.returnDate = null;
        this.fine = 0.0;
        totalRecords++;
    }

    public String getRecordId() { return recordId; }
    public String getMemberId() { return memberId; }
    public String getIsbn() { return isbn; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public double getFine() { return fine; }
    public static int getTotalRecords() { return totalRecords; }

    public boolean isOverdue() {
        LocalDate checkDate = (returnDate == null) ? LocalDate.now() : returnDate;
        return checkDate.isAfter(dueDate);
    }

    public double calculateFine() {
        LocalDate endDate = (returnDate == null) ? LocalDate.now() : returnDate;
        long lateDays = ChronoUnit.DAYS.between(dueDate, endDate);
        if (lateDays <= 0) return 0.0;
        // Use library fine per day from LibraryUtils
        return LibraryUtils.calculateLateFee((int) lateDays);
    }

    public void returnBook() {
        if (this.returnDate != null) return; // already returned
        this.returnDate = LocalDate.now();
        this.fine = calculateFine();
    }

    public boolean extendLoan(int extraDays) {
        if (returnDate != null) return false; // already returned
        this.dueDate = this.dueDate.plusDays(extraDays);
        return true;
    }

    @Override
    public String toString() {
        return String.format("Record[%s] Member:%s ISBN:%s Borrow:%s Due:%s Return:%s Fine:%.2f",
                recordId, memberId, isbn, borrowDate, dueDate, (returnDate == null ? "-" : returnDate), fine);
    }
}
