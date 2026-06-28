package Jobsheet16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainNilai03 {

    
    static ArrayList<Mahasiswa03> daftarMhs = new ArrayList<>();
    static ArrayList<MataKuliah03> daftarMK = new ArrayList<>();
    static ArrayList<Nilai03> daftarNilai = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Data Mahasiswa
        daftarMhs.add(new Mahasiswa03("20001", "Thalhah", "021xxx"));
        daftarMhs.add(new Mahasiswa03("20002", "Zubair", "021xxx"));
        daftarMhs.add(new Mahasiswa03("20003", "Abdur-Rahman", "021xxx"));
        daftarMhs.add(new Mahasiswa03("20004", "Sa'ad", "021xxx"));
        daftarMhs.add(new Mahasiswa03("20005", "Sa'id", "021xxx"));
        daftarMhs.add(new Mahasiswa03("20006", "Ubaidah", "021xxx"));

        // Data Mata Kuliah
        daftarMK.add(new MataKuliah03("00001", "Internet of Things", 3));
        daftarMK.add(new MataKuliah03("00002", "Algoritma dan Struktur Data", 2));
        daftarMK.add(new MataKuliah03("00003", "Algoritma dan Pemrograman", 2));
        daftarMK.add(new MataKuliah03("00004", "Praktikum Algoritma dan Struktur Data", 3));
        daftarMK.add(new MataKuliah03("00005", "Praktikum Algoritma dan Pemrograman", 3));

        menu();
    }

    static void menu() {
        int pilih;

        do {
            System.out.println("-----------------------------------------------");
            System.out.println("SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
            System.out.println("-----------------------------------------------");
            System.out.println();
            System.out.println("1. Input Nilai");
            System.out.println("2. Tampil Nilai");
            System.out.println("3. Mencari Nilai Mahasiswa");
            System.out.println("4. Urut Data Nilai");
            System.out.println("5. Hapus Data Mahasiswa");
            System.out.println("6. Keluar");
            System.out.println("-----------------------------------------------");

            System.out.print("Pilih : ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    inputNilai();
                    break;

                case 2: 
                    tampilNilai();
                    break;

                case 3:
                    cariNilai();
                    break;
                
                case 4:
                    urutNilai();
                    break;

                case 5:
                    hapusDataQueue();
                    break;
                
                case 6:
                    System.out.println("Program selesai");
                    break;

            }
            
        } while (pilih != 6);
    }

    static void inputNilai() {

        System.out.println("\nMasukan Data");

        System.out.print("Kode  : ");
        String kode = sc.next();

        System.out.print("Nilai : ");
        double nilai = sc.nextDouble();

        // --- DAFTAR MAHASISWA ---
        System.out.println("\nDAFTAR MAHASISWA");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-8s %-18s %-10s\n", "NIM", "Nama", "Telp");

        for (Mahasiswa03 m : daftarMhs) {
            System.out.printf("%-8s %-18s %-10s\n", m.nim, m.nama, m.telp);
        }

        System.out.print("Pilih mahasiswa by nim: ");
        String nim = sc.next();

        Mahasiswa03 mhsDipilih = null;

        for (Mahasiswa03 m : daftarMhs) {
            if (m.nim.equals(nim)) {
                mhsDipilih = m;
                break;
            }
        }

        if (mhsDipilih == null) {
            System.out.println("Mahasiswa tidak ditemukan");
            return;
        }

        // --- DAFTAR MATA KULIAH ---
        System.out.println("\nDAFTAR MATA KULIAH");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-8s %-45s %-3s\n", "Kode", "Mata Kuliah", "SKS");

        for (MataKuliah03 mk : daftarMK) {
            System.out.printf("%-8s %-45s %-3d\n", mk.kode, mk.namaMK, mk.sks);
        }

        System.out.print("Pilih MK by kode: ");
        String kodeMK = sc.next();

        MataKuliah03 mkDipilih = null;

        for (MataKuliah03 mk : daftarMK) {
            if (mk.kode.equals(kodeMK)) {
                mkDipilih = mk;
                break;
            }
        }

        if (mkDipilih == null) {
            System.out.println("Kode MK tidak ditemukan");
            return;
        }

        daftarNilai.add(new Nilai03(mhsDipilih, mkDipilih, nilai));

        System.out.println("\nData berhasil ditambahkan.");
    }

    static void tampilNilai() {
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.println("-----------------------------------------------");

        System.out.printf("%-8s %-15s %-35s %-5s %-8s\n", "NIM", "Nama", "Mata Kuliah", "SKS", "Nilai");

        for (Nilai03 n : daftarNilai) {
            System.out.printf("%-8s %-15s %-35s %-5d %-8.2f\n",
                                n.mahasiswa.nim,
                                n.mahasiswa.nama,
                                n.matkul.namaMK,
                                n.matkul.sks,
                                n.nilai);
        }
    }

    static void cariNilai() {
       
        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.println("-----------------------------------------------");

        System.out.printf("%-8s %-15s %-35s %-5s %-8s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");

        for (Nilai03 n : daftarNilai) {
            System.out.printf("%-8s %-15s %-35s %-5d %-8.2f\n", n.mahasiswa.nim, n.mahasiswa.nama, n.matkul.namaMK, n.matkul.sks, n.nilai);
        }

        System.out.print("\nMasukkan data mahasiswa[nim] : ");
        String nim = sc.next();

        int totalSKS = 0;

        System.out.printf("%-8s %-15s %-35s %-5s %-8s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");

        for (Nilai03 n : daftarNilai) {
            if (n.mahasiswa.nim.equals(nim)) {

                System.out.printf("%-8s %-15s %-35s %-5d %-8.2f\n", n.mahasiswa.nim, n.mahasiswa.nama, n.matkul.namaMK, n.matkul.sks, n.nilai);

                totalSKS += n.matkul.sks;
            }
        }

        System.out.println("Total SKS " + totalSKS + " telah diambil.");
    }

    static void urutNilai() {
        daftarNilai.sort(Comparator.comparingDouble(n -> n.nilai));

        System.out.println("\nDAFTAR NILAI MAHASISWA");
        System.out.println("-----------------------------------------------");

        System.out.printf("%-8s %-15s %-35s %-5s %-8s\n", "Nim", "Nama", "Mata Kuliah", "SKS", "Nilai");

        for (Nilai03 n : daftarNilai) {

            System.out.printf("%-8s %-15s %-35s %-5d %-8.2f\n", n.mahasiswa.nim, n.mahasiswa.nama, n.matkul.namaMK, n.matkul.sks, n.nilai);
        }
    }

    static void hapusDataQueue() {
        if (daftarNilai.isEmpty()) {
            System.out.println("\nData nilai masih kosong!");
            return;
        }

        Nilai03 hapus = daftarNilai.remove(0);

        System.out.println("\nData pertama berhasil dihapus");
        System.out.println("-----------------------------------------------");
        System.out.println("NIM     : " + hapus.mahasiswa.nim);
        System.out.println("Nama    : " + hapus.mahasiswa.nama);
        System.out.println("MK      : " + hapus.matkul.namaMK);
        System.out.println("Nilai   : " + hapus.nilai);
    }
}
