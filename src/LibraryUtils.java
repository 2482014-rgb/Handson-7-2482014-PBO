import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LibraryUtils {
    public static final double DEFAULT_FINE_PER_DAY = 2000.0; // Rp per day
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LibraryUtils() { /* prevent instantiation */ }

    public static boolean isValidISBN(String isbn) {
        if (isbn == null) return false;
        String digits = isbn.replaceAll("[^0-9Xx]", "");
        return digits.length() >= 10; // simplistic
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static String formatDate(LocalDate d) {
        return d == null ? "-" : d.format(DATE_FORMAT);
    }

    public static double calculateLateFee(int lateDays) {
        if (lateDays <= 0) return 0.0;
        return DEFAULT_FINE_PER_DAY * lateDays;
    }
}
