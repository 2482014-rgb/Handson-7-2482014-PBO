public class Perpustakaan {

    // Method untuk meminjam buku
    public void pinjamBuku(Mahasiswa mahasiswa, Buku buku) {
        if (buku.pinjam()) {
            System.out.println(mahasiswa.nama + " berhasil meminjam buku: " + buku.judul);
        } else {
            System.out.println("Maaf, buku \"" + buku.judul + "\" sedang dipinjam.");
        }
    }

    // Method untuk mengembalikan buku
    public void kembalikanBuku(Mahasiswa mahasiswa, Buku buku) {
        buku.kembalikan();
        System.out.println(mahasiswa.nama + " telah mengembalikan buku: " + buku.judul);
    }
}

