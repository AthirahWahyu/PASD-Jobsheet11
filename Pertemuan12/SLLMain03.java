package Pertemuan12;

public class SLLMain03 {
    public static void main(String[] args) {
        SingleLinkedList03 sll = new SingleLinkedList03();

        Mahasiswa03 mhs1 = new Mahasiswa03("24212200",  "Alvaro", "1A", 4.0);
        Mahasiswa03 mhs2 = new Mahasiswa03("22212202",  "Cintia", "3C", 3.5);
        Mahasiswa03 mhs3 = new Mahasiswa03("23212201",  "Bimon", "2B", 3.8);
        Mahasiswa03 mhs4 = new Mahasiswa03("21212203",  "Dirga", "4D", 3.6);

        sll.addFirst(mhs4); // menambah Dirga
        sll.addLast(mhs1); // menambah Alvaro di akhir
        sll.insertAfter("Dirga", mhs3); // menambah Bimon setelah Dirga
        sll.insertAt(1, mhs2); // menambah Cintia di index 1 (sebelum Bimon
        
        System.out.println("Kondisi Awal:");
        sll.print();

        // Mengakses data pada indeks tertentu
        System.out.println("data index 1: ");
        sll.getData(1);

        // Mencari indeks berdasarkan Nama (key)
        System.out.println("data mahasiswa an Bimon berada pada index: " + sll.indexOf("Bimon"));
        System.out.println();

        // Menghapus data paling depan
        sll.removeFirst();

        // Menghapus data paling belakang
        sll.removeLast();

        // Cetak hasil setelah removeFirst dan removeLast
        sll.print();

        // Menghapus data pada indeks tertentu (indeks 0)
        sll.removeAt(0);

        // Mencetak hasil akhir
        sll.print();
    }
}