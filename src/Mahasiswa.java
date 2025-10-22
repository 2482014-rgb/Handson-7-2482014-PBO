public class Mahasiswa {
    // Instance variables
    String nama;
    String nim;
    String jurusan;
    double ipk;

    // Constructor
    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    // Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfo() {
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("IPK     : " + ipk);
        System.out.println();
    }

    // Method untuk mengecek kelulusan
    public boolean isLulus() {
        return ipk >= 2.75;
    }

    // Method untuk mendapatkan predikat IPK
    public String getPredikat() {
        if (ipk >= 3.75) return "Cumlaude";
        else if (ipk >= 3.00) return "Sangat Memuaskan";
        else if (ipk >= 2.75) return "Memuaskan";
        else return "Tidak Lulus";
    }
}