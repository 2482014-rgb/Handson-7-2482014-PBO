public class IntroToOOPPractice {
    public static void main(String[] args) {
        System.out.println("=== DENGAN OOP: CARA OBJECT-ORIENTED ===");

        // Membuat 3 object Mahasiswa
        Mahasiswa m1 = new Mahasiswa("Andre", "2381031", "Teknik Informatika", 3.8);
        Mahasiswa m2 = new Mahasiswa("Bela", "2482014", "Sistem Informasi", 3.9);
        Mahasiswa m3 = new Mahasiswa("Jelita", "2582002", "Sistem Informasi", 3.7);

        // Menampilkan data mahasiswa
        m1.tampilkanInfo();
        m2.tampilkanInfo();
        m3.tampilkanInfo();

        // Mengecek kelulusan & predikat
        System.out.println(m1.nama + " lulus? " + m1.isLulus() + " | Predikat: " + m1.getPredikat());
        System.out.println(m2.nama + " lulus? " + m2.isLulus() + " | Predikat: " + m2.getPredikat());
        System.out.println(m3.nama + " lulus? " + m3.isLulus() + " | Predikat: " + m3.getPredikat());

        System.out.println("\n=== ANALOGI PERPUSTAKAAN ===");

        // Membuat buku
        Buku b1 = new Buku("Pemrograman Java", "Budi Santoso", "ISBN001", 2019);
        Buku b2 = new Buku("Dasar OOP", "Ani Setiawan", "ISBN002", 2021);

        // Menampilkan info buku
        b1.tampilkanInfo();
        b2.tampilkanInfo();

        // Peminjaman buku
        Perpustakaan perpustakaan = new Perpustakaan();
        perpustakaan.pinjamBuku(m1, b1);
        perpustakaan.pinjamBuku(m2, b2);
        perpustakaan.pinjamBuku(m3, b1); // Buku b1 sudah dipinjam, cek pesan

        // Pengembalian buku
        perpustakaan.kembalikanBuku(m1, b1);
        perpustakaan.pinjamBuku(m3, b1); // Sekarang bisa dipinjam lagi
    }
}