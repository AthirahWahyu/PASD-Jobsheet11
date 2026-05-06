package Pertemuan12;
import java.util.Scanner;

public class SLLMain03 {
    public static void main(String[] args) {
        SingleLinkedList03 sll = new SingleLinkedList03();
        Scanner sc03 = new Scanner (System.in);
        int pilih;

        do {
            System.out.println("\n--- Menu Linked List Mahasiswa ---");
            System.out.println("1. Tambah Depan (addFirst)");
            System.out.println("2. Tambah Belakang (addLast)");
            System.out.println("3. Tambah Setelah Nama (insertAfter)");
            System.out.println("4. Tambah pada Indeks (insertAt)");
            System.out.println("5. Cetak Semua Data");
            System.out.println("6. keluar");
            System.out.print("Pilih menu (1-6): ");
            pilih = sc03.nextInt();
            sc03.nextLine();

            if (pilih >= 1 && pilih <= 4) {
                // Proses Input Data Mahasiswa
                System.out.print("NIM   : ");
                String nim = sc03.nextLine();
                System.out.print("Nama  : ");
                String nama = sc03.nextLine();
                System.out.print("Kelas : ");
                String kelas = sc03.nextLine();
                System.out.print("IPK   : ");
                double ipk = sc03.nextDouble();
                sc03.nextLine();

                Mahasiswa03 mhs = new Mahasiswa03(nim, nama, kelas, ipk);

                switch (pilih) {
                    case 1:
                        sll.addFirst(mhs);
                        break;
                    case 2:
                        sll.addLast(mhs);
                        break;
                    case 3:
                        System.out.print("Masukkan Nama Key (Mahasiswa sebelumnya): ");
                        String key = sc03.nextLine();
                        sll.insertAfter(key, mhs);
                        break;
                    case 4: 
                        System.out.print("Masukkan Indeks Tujuan: ");
                        int idx = sc03.nextInt();
                        sll.insertAt(idx, mhs);
                        break;
                }
                System.out.println("Data berhasil ditambahkan.");
            } else if (pilih == 5) {
                sll.print();
            }
            
        } while (pilih != 6);

        System.out.println("Program Berhenti.");
        sc03.close();
    }
}
