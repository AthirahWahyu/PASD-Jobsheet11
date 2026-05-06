package Pertemuan12;
public class SingleLinkedList03 {
    NodeMahasiswa03 head;
    NodeMahasiswa03 tail;

    boolean isEmpty() {
        return (head == null);
    }

    public void print() {
        if (!isEmpty()) {
            NodeMahasiswa03 tmp = head;
            System.out.println("Isi Linked List:\t");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public void addFirst(Mahasiswa03 input) {
        NodeMahasiswa03 ndInput = new NodeMahasiswa03(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(Mahasiswa03 input) {
        NodeMahasiswa03 ndInput = new NodeMahasiswa03(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(String key, Mahasiswa03 input) {
        NodeMahasiswa03 ndInput = new NodeMahasiswa03(input, null);
        NodeMahasiswa03 temp = head;
        do {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
            break;
            }
            temp = temp.next;
        } while (temp != null);
    }

    public void insertAt(int index, Mahasiswa03 input) {
        if (index < 0) {
            System.out.println("ideks salah");            
        } else if (index == 0) {
            addFirst(input);
        } else {
            NodeMahasiswa03 temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;  
            }
            temp.next = new NodeMahasiswa03(input, temp.next);
            if (temp.next.next == null) {
                tail = temp.next;
            }
        }
    }
} 