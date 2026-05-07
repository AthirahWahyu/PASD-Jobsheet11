package Pertemuan12;
import java.util.Scanner;

public class MainTugas03 {
    public static void main(String[] args) {
        QueueLinkedList03 antrian = new QueueLinkedList03();
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\n==================================");
            System.out.println("--- LAYANAN UNIT KEMAHASISWAAN ---");
            System.out.println("==================================");
            System.out.println("1. Mahasiswa Daftar (Enqueue)");
            System.out.println("2. Panggil Antrian (Dequeue)");
            System.out.println("3. Cek Antrian Terdepan (Peek)");
            System.out.println("4. Lihat Semua Antrian (Display)");
            System.out.println("5. Cek Apakah Antrian Kosong");
            System.out.println("6. Cek Apakah Antrian Penuh");
            System.out.println("7. Kosongkan Seluruh Antrian (Clear)");
            System.out.println("8. Keluar");
            System.out.println("----------------------------------");
            System.out.print("Pilih Menu (1-8): ");

            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan NIM  : ");
                    String nim = sc.nextLine();
                    System.out.print("Masukkan Nama : ");
                    String nama = sc.nextLine();
                    antrian.enqueue(new MahasiswaTugas03(nim, nama));
                    break;
            
                case 2: 
                    antrian.dequeue();
                    break;

                case 3: 
                    antrian.peek();
                    break;

                case 4:
                    antrian.display();
                    break;

                case 5: 
                    if (antrian.isEmpty()) {
                        System.out.println("Status: Antrian saat ini KOSONG.");   
                    } else {
                        System.out.println("Status: Antrian TIDAK kosong.");
                    }
                    break;
                
                case 6: 
                    if (antrian.isFull()) {
                        System.out.println("Status: Antrian PENUH.");
                    } else {
                        System.out.println("Status: Antrian TIDAK penuh (Linked List bersifat dinamis.)");
                    }
                    break;

                case 7:
                    System.out.print("Apakah Anda yakin ingin mengosongkan semua antrian? (y/n): ");
                    String konfirmasi = sc.nextLine();
                    if (konfirmasi.equalsIgnoreCase("y")) {
                    }
                    break;
                
                case 8:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-8.");
            }
        } while (pilih != 8);

        sc.close();  
    }    
}
