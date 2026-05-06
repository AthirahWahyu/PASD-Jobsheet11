package Pertemuan12;

public class SLLMain03 {
    public static void main(String[] args) {
        SingleLinkedList03 sll = new SingleLinkedList03();

        Mahasiswa03 mhs1 = new Mahasiswa03("24212200",  "Alvaro", "1A", 4.0);
        Mahasiswa03 mhs2 = new Mahasiswa03("22212202",  "Cintia", "3C", 3.5);
        Mahasiswa03 mhs3 = new Mahasiswa03("23212201",  "Bimon", "2B", 3.8);
        Mahasiswa03 mhs4 = new Mahasiswa03("21212203",  "Dirga", "4D", 3.6);

        sll.print(); // kondisi kosong

        sll.addFirst(mhs4); // menambah Dirga
        sll.print();

        sll.addLast(mhs1); // menambah Alvaro di akhir
        sll.print();

        sll.insertAfter("Dirga", mhs3); // menambah Bimon setelah Dirga
        sll.insertAt(1, mhs2); // menambah Cintia di index 1 (sebelum Bimon
        sll.print();
    }
}
