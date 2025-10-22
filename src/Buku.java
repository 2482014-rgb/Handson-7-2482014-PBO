public class Buku {
    String judul;
    String penulis;
    String isbn;
    int tahunTerbit;
    boolean tersedia;

    // Constructor
    public Buku(String judul, String penulis, String isbn, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.tahunTerbit = tahunTerbit;
        this.tersedia = true; // default: tersedia
    }

    // Method untuk menampilkan info buku
    public void tampilkanInfo() {
        System.out.println("Judul        : " + judul);
        System.out.println("Penulis      : " + penulis);
        System.out.println("ISBN         : " + isbn);
        System.out.println("Tahun Terbit : " + tahunTerbit);
        System.out.println("Status       : " + (tersedia ? "Tersedia" : "Dipinjam"));
        System.out.println();
    }

    // Method untuk meminjam buku
    public boolean pinjam() {
        if (tersedia) {
            tersedia = false;
            return true;
        } else {
            return false;
        }
    }

    // Method untuk mengembalikan buku
    public void kembalikan() {
        tersedia = true;
    }
}
