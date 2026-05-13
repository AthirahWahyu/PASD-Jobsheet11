package Jobsheet12;

public class DoubleLinkedList03 {
    Node03 head;
    Node03 tail;

    public DoubleLinkedList03() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa03 data) {
        Node03 newNode03 = new Node03(data);
        if (isEmpty()) {
            head = tail = newNode03;
        } else {
            newNode03.next = head;
            head.prev = newNode03;
            head = newNode03;
        }
    }

    public void addLast(Mahasiswa03 data) {
        Node03 newNode03 = new Node03(data);
        if (isEmpty()) {
            head = tail = newNode03;
        } else {
            tail.next = newNode03;
            newNode03.prev = tail;
            tail = newNode03;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa03 data) {
        Node03 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node03 newNode03 = new Node03(data);

        // Jika current adalah tail, node baru ditambahkan di akhir
        if (current == tail) {
            newNode03.prev = current;
            current.next = newNode03;
            tail = newNode03;
        } else { // node baru disisipkan di tengah 
            newNode03.prev = current;
            newNode03.next = current.next;
            current.next.prev = newNode03;
            current.next = newNode03;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong.");
            return;
        }

        Node03 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }
}
