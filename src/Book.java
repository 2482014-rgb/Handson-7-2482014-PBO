import java.time.LocalDate;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private BookCategory category;
    private boolean isAvailable;
    private int borrowCount;

    // static
    private static int totalBooks = 0;

    // Constructors
    public Book(String isbn, String title, String author, String publisher, int yearPublished, BookCategory category) {
        if (!LibraryUtils.isValidISBN(isbn)) throw new IllegalArgumentException("ISBN tidak valid");
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher == null ? "Unknown" : publisher;
        this.yearPublished = yearPublished;
        this.category = category == null ? BookCategory.NON_FICTION : category;
        this.isAvailable = true;
        this.borrowCount = 0;
        totalBooks++;
    }

    // Getters & setters (some are read-only)
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("Title tidak boleh kosong");
        this.title = title;
    }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }
    public BookCategory getCategory() { return category; }
    public void setCategory(BookCategory category) { this.category = category; }
    public boolean isAvailable() { return isAvailable; }
    public int getBorrowCount() { return borrowCount; }
    public static int getTotalBooks() { return totalBooks; }

    // Business methods
    public boolean borrowBook() {
        if (!this.isAvailable) return false;
        this.isAvailable = false;
        this.borrowCount++;
        return true;
    }

    public boolean returnBook() {
        if (this.isAvailable) return false;
        this.isAvailable = true;
        return true;
    }

    public double getPopularityScore() {
        int age = getAgeInYears();
        return borrowCount * 1.0 / (1 + Math.max(0, age));
    }

    // Utility
    public void displayBookInfo() {
        System.out.println("[" + isbn + "] " + title + " by " + author + " (" + yearPublished + ") - " +
                (isAvailable ? "Available" : "Borrowed") + " | Borrowed: " + borrowCount);
    }

    public boolean isClassic() {
        return getAgeInYears() >= 25;
    }

    public int getAgeInYears() {
        return LocalDate.now().getYear() - yearPublished;
    }
}
