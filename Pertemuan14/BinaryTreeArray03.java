package Pertemuan14;

public class BinaryTreeArray03 {
    int[] data;
    int idxLast;

    public BinaryTreeArray03(int size) {
        data = new int[size];
        idxLast = -1;
    }

    public void populateData(int[] dataInput, int last) {
        this.data = dataInput;
        this.idxLast = last;
    }

    public void add(int element) {
        if (idxLast >= data.length -1) {
            System.out.println("Array Tree sudah penuh!");
            return;
        }
        idxLast++;
        data[idxLast] = element;
    }

    public void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != 0) {
                traverseInOrder(2 * idxStart + 1);
                System.out.print(data[idxStart] + " ");
                traverseInOrder(2 * idxStart + 2);
            }  
        }
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != 0) {
                System.out.print(data[idxStart] + " ");
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }
    }

    public void traversePostOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != 0) {
                traversePostOrder(2 * idxStart + 1);
                traversePostOrder(2 * idxStart + 2);
                System.out.print(data[idxStart] + " ");   
            }   
        }
    }
}


