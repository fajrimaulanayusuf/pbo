/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiketkereta;
import java.util.Scanner;
/**
 *
 * @author Famjri
 */

abstract class Penumpang {
    protected String nama;
    protected String noTiket;

    public Penumpang(String nama, String noTiket) {
        this.nama = nama;
        this.noTiket = noTiket;
    }

    public abstract double hitungHargaTiket();

    public void tampilkanData() {
        System.out.println("Nama        : " + nama);
        System.out.println("No Tiket    : " + noTiket);
        System.out.printf("Harga Tiket : Rp %.0f%n", hitungHargaTiket());
    }

    public void tampilkanData(String pesanTambahan) {
        tampilkanData();
        System.out.println("Keterangan  : " + pesanTambahan);
    }
}

class PenumpangReguler extends Penumpang {
    public PenumpangReguler(String nama, String noTiket) {
        super(nama, noTiket);
    }

    @Override
    public double hitungHargaTiket() {
        return 50000;
    }
}

class PenumpangVIP extends Penumpang {
    public PenumpangVIP(String nama, String noTiket) {
        super(nama, noTiket);
    }

    @Override
    public double hitungHargaTiket() {
        return 100000;
    }
}

class InputPenumpang {
    protected Scanner input = new Scanner(System.in);
    
    public String inputString(String label) {
        System.out.print(label + ": ");
        return input.nextLine();
    }
    
    public int inputInt(String label) {
        System.out.print(label + ": ");
        while (!input.hasNextInt()) {
            System.out.print("Input harus angka! " + label + ": ");
            input.next();
        }
        int hasil = input.nextInt();
        input.nextLine();
        return hasil;
    }
}

public class TiketKereta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputPenumpang in = new InputPenumpang();
        Penumpang penumpang = null;

        System.out.println("APLIKASI TIKET KERETA");
        System.out.println("1. Penumpang Reguler");
        System.out.println("2. Penumpang VIP");
        
        int pilihan = in.inputInt("Pilih Tipe Penumpang (1/2)");
        String nama = in.inputString("Masukkan Nama");
        String noTiket = in.inputString("Masukkan No Tiket");

        if (pilihan == 1) {
            penumpang = new PenumpangReguler(nama, noTiket);
            System.out.println("TIKET REGULER");
            penumpang.tampilkanData(); 
        } else if (pilihan == 2) {
            penumpang = new PenumpangVIP(nama, noTiket);
            System.out.println("TIKET VIP");
            penumpang.tampilkanData("Mendapat Snack Gratis & Kursi Prioritas");
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
}
