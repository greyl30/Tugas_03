// Neyla Mujahidah Villah
// 235150700111008 - TI-A
// Praktikum Pemrograman Lanjut


public class Kereta {

    // Mendeklarasikan variabel nama, jumlah tiket, dan objek dari kelas Ticket
    private String nama;
    private int jmlTiket;
    private Ticket tiket;

    // Default konstruktor kereta komuter
    public Kereta() {
        this.nama = ""; // String kosong maksudnya secara default tidak memiliki nama
        this.jmlTiket = 1000; // Jumlah tiket default
        this.tiket = new Ticket(); // Membuat objek baru dari kelas Ticket dan menyimpannya pada variable tiket
    }

    // Overload konstruktor KJJ
    public Kereta(String n, int jmlTiket) {
        this.nama = n;
        this.jmlTiket = jmlTiket; // Menetapkan jumlah tiket sesuai nilai yang diberikan
        this.tiket = new Ticket(n, jmlTiket); // Inisialisasi nama n dan jmlTiket
    }

    // Mendeklarasikan method tambah tiket
    public void tambahTiket(String namaPenumpang) {
        if (this.nama.equals("")) { // Memeriksa jika nama kereta kosong, maka akan dianggap sebagai kereta komuter
            if (jmlTiket > 0) { // Memeriksa jika jumlah tiket > 0, maka tiket masih tersedia

                String[] penumpang = tiket.getNamaPenumpang(); // Mengambil data nama dari objek tiket
                String[] newPenumpang = new String[penumpang.length + 1]; // Membuat array untuk menambah penumpang baru

                // Menyalin data penumpang dalam array penumpang baru
                for (int i = 0; i < penumpang.length; i++) {
                    newPenumpang[i] = penumpang[i];
                }
                // Menambahkan penumpang baru dalam array 
                newPenumpang[penumpang.length] = namaPenumpang;

                // Mengatur kembali array penumpang di objek tiket
                tiket.setNamaPenumpang(newPenumpang);
                jmlTiket--; // Tiket berkurang jika terjual
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan");
            } else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        } else {
            System.out.println("==================================================");
        }
    }
    
    // Overload method
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (!this.nama.equals("")) { 
            if (jmlTiket > 0) { // Mengecek jika tiket > 0 maka tiket masih tersedia
                String[] penumpang = tiket.getNamaPenumpang(); // Aray penumpang dari objek tiket
                // Array baru untuk menambah penumpang baru
                String[] newPenumpang = new String[penumpang.length + 1];
                String[] newAsal = new String[penumpang.length + 1];
                String[] newTujuan = new String[penumpang.length + 1];
    
                // Menyalin data penumpang lama ke array baru
                for (int i = 0; i < penumpang.length; i++) { // Mengiterasi data penumpang
                    // Menyalin array penumpang ke array penumpang baru
                    newPenumpang[i] = penumpang[i]; 
                    newAsal[i] = tiket.getAsal()[i];
                    newTujuan[i] = tiket.getTujuan()[i];
                }
    
                // Menambahkan penumpang baru
                newPenumpang[penumpang.length] = namaPenumpang;
                newAsal[penumpang.length] = asal;
                newTujuan[penumpang.length] = tujuan;
    
                // Mengatur kembali array penumpang di objek tiket
                tiket.setNamaPenumpang(newPenumpang);
                tiket.setAsal(newAsal);
                tiket.setTujuan(newTujuan);
                jmlTiket--;
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jmlTiket);
            } else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        } else {
            System.out.println("==================================================");
        }
    }
    
    public void tampilkanTiket() {
        System.out.println("==================================================");
        if (this.nama.equals("")) {
            System.out.println("Daftar penumpang kereta api komuter: ");
            System.out.println("----------------------------");

        } else {
            System.out.println("Daftar penumpang kereta api " + this.nama);
            System.out.println("----------------------------");
        }
        
        // Berisi data penumpang 
        String[] namaPenumpangArray = tiket.getNamaPenumpang();
        String[] asalArray = tiket.getAsal();
        String[] tujuanArray = tiket.getTujuan();

        
        if (namaPenumpangArray.length > 0) {
            for (int i = 0; i < namaPenumpangArray.length; i++) { // Mengiterasi setiap nama penumpang
                System.out.println("Nama: " + namaPenumpangArray[i]);

                // Mengecek apakah array bernilai null, jika keduanya true maka akan menjalankan sout di bawah
                if (asalArray != null && tujuanArray != null) {
                    System.out.println("Asal: " + asalArray[i]);
                    System.out.println("Tujuan: " + tujuanArray[i]);
                    System.out.println("----------------------------");
                }      
            }
        
        } else {
            System.out.println("Tidak ada penumpang");
        }
    }
}
