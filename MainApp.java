// ===== Soal 1 =====

abstract class Kendaraan {
    // Abstraksi: method abstract tanpa implementasi
    public abstract void nyalakanMesin();
}

interface Listrik {
    // Interface untuk kendaraan listrik
    void isiDayaBaterai();
}

class Mobil extends Kendaraan implements Listrik {
    @Override
    public void nyalakanMesin() {
        System.out.println("Mesin mobil menyala dengan sistem tanpa kunci.");
    }

    @Override
    public void isiDayaBaterai() {
        System.out.println("Baterai mobil sedang diisi daya.");
    }
}

class Motor extends Kendaraan {
    @Override
    public void nyalakanMesin() {
        System.out.println("Mesin motor dinyalakan dengan engkol.");
    }
}

public class MainApp {
    public static void main(String[] args) {
        // Polimorfisme: variabel bertipe superclass menyimpan objek subclass
        Kendaraan mobilSaya = new Mobil();
        Kendaraan motorSaya = new Motor();

        mobilSaya.nyalakanMesin();        // Output: mesin mobil...
        motorSaya.nyalakanMesin();        // Output: mesin motor...

        // Cek dan cast ke interface Listrik untuk akses method isiDayaBaterai()
        if (mobilSaya instanceof Listrik) {
            Listrik mobilListrik = (Listrik) mobilSaya;
            mobilListrik.isiDayaBaterai(); // Output: baterai mobil...
        }
    }
}

// ===== Soal 2 =====

// ========== Pilihan 3: Sistem Kasir ==========

abstract class Produk {
    protected String nama;
    protected double harga;

    public Produk(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungTotalHarga();
}

interface KenaPajak {
    double hitungPajak();
}

class Makanan extends Produk implements KenaPajak {
    public Makanan(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungPajak() {
        return harga * 0.05;
    }

    @Override
    public double hitungTotalHarga() {
        return harga + hitungPajak();
    }
}

class Minuman extends Produk implements KenaPajak {
    public Minuman(String nama, double harga) {
        super(nama, harga);
    }

    @Override
    public double hitungPajak() {
        return harga * 0.10;
    }

    @Override
    public double hitungTotalHarga() {
        return harga + hitungPajak();
    }
}

// Contoh penggunaan sistem kasir
class AplikasiKasir {
    public static void main(String[] args) {
        Produk[] daftarBarang = {
            new Makanan("Nasi Goreng", 24000),
            new Minuman("Teh Manis", 4500)
        };

        double totalBelanja = 0;
        for (Produk barang : daftarBarang) {
            System.out.println(barang.nama + ": Rp" + barang.hitungTotalHarga());
            totalBelanja += barang.hitungTotalHarga();
        }

        System.out.println("Total belanja: Rp" + totalBelanja);
        System.out.println("Terima kasih telah berbelanja :)");
    }
}
