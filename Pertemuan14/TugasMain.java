package Pertemuan14;

public class TugasMain {
    public static void main(String[] args) {
        System.out.println("====== VERIFIKASI TUGAS PRAKTIKUM 1 ======");
        BinaryTree03 bstTugas = new BinaryTree03();

        // Menggunakan add rekursif
        bstTugas.addRekursif(new Mahasiswa03("01", "Roni", "TI-1A", 3.20));
        bstTugas.addRekursif(new Mahasiswa03("02", "Sita", "TI-1B", 3.89));
        bstTugas.addRekursif(new Mahasiswa03("03", "Tono", "TI-1A", 3.45));
        bstTugas.addRekursif(new Mahasiswa03("04", "Vina", "TI-1C", 3.95));
        bstTugas.addRekursif(new Mahasiswa03("05", "Amir", "TI-1B", 3.80));

        // Test Min Max
        bstTugas.cariMinIPK();
        bstTugas.cariMaxIPK();
        System.out.println();

        // Test tampil IPK diatas batas 
        bstTugas.tampilMahasiswaIPKdiAtas(3.40);
        System.out.println();

        System.out.println("====== VERIFIKASI HASIL TUGAS PRAKTIKUM 2 (ARRAY) ======");
        BinaryTreeArray03 arrayTree = new BinaryTreeArray03(15);
        arrayTree.add(50);
        arrayTree.add(30);
        arrayTree.add(70);
        arrayTree.add(20);
        arrayTree.add(40);

        System.out.print("PreOrder  : "); 
        arrayTree.traversePreOrder(0);
        System.out.println();

        System.out.print("InOrder : ");
        arrayTree.traverseInOrder(0);
        System.out.println();

        System.out.print("PostOrder : ");
        arrayTree.traversePostOrder(0);
        System.out.println();
    }  
}

