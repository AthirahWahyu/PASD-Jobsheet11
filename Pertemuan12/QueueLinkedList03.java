package Pertemuan12;

public class QueueLinkedList03 {
    NodeTugas03 front, rear;
    int size;

    public QueueLinkedList03() {
        front = rear = null;
        size = 0;
    }

    // Cek Antrian Kosong
    public boolean isEmpty() {
        return front == null;
    }

    // Cek Antrian Penuh 
    // (Dalam Linked List selalu false karena dinamis)
    public boolean isFull(){
        return false;
    }

    // Mengosongkan Antrian 
    public void clear() {
        front = rear = null;
        size = 0;
        System.out.println("Antrian telah dikosongkan.");
    }

    // Menambahkan antrian (Enqueue)
    public void enqueue(MahasiswaTugas03 data) {
        NodeTugas03 newNode = new NodeTugas03(data, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(data.nama + " telah masuk antrian.");
    }

    // Mengeluarkan/Memproses antrian (Dequeue)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Memproses antrian: " + front.data.nama);
        front = front.next;
        if (front == null) 
            rear = null;
        size--;
    }

    // Melihat antrian paling depan
    public void peek() {
        if (!isEmpty()) {
            System.out.println("Antrian terdepan saat ini: ");
            front.data.tampilData();
        } else {
            System.out.println("Antrian kosong.");
        }
    }

    // Menampilkan seluruh antrian
    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            NodeTugas03 temp = front;
            System.out.println("\n--- DAFTAR SELURUH ANTRIAN SAAT INI ---");
            while (temp != null) {
                temp.data.tampilData();
                temp = temp.next;
            }
            System.out.println("Jumlah antrian: " + size + " mahasiswa.");
        }
    }
}
