package Pertemuan14;

public class BinaryTree03 {
    Node03 root;

    public BinaryTree03() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa03 mahasiswa) {
        Node03 newNode = new Node03(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node03 current = root;
            Node03 parent = null;
            while (true) {
                parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    boolean find(double ipk) {
        boolean result = false;
        Node03 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if(ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    void traversePreOrder(Node03 node){
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traverseInOrder(Node03 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    void traversePostOrder(Node03 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    Node03 getSuccessor(Node03 del) {
        Node03 successor = del.right;
        Node03 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    void delete(double ipk){
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }

        // cari node (current) yang akan dihapus
        Node03 parent = root;
        Node03 current = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if(ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        // penghapusan
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;            
        } else {
            // jika tidak ada anak (leaf), maka node dihapus
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild){
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if(current.left == null) { // jika hanya punya 1 anak (kanan)
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild){
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if(current.right == null) { // jika hanya punya 1 anak (kiri)
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild){
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else { // jika punya 2 anak
                Node03 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }
    public void addRekursif(Mahasiswa03 mhs) {
        root = addRekursifHelper(root, mhs);
    }

    private Node03 addRekursifHelper(Node03 current, Mahasiswa03 mhs) {
        if (current == null) {
            return new Node03(mhs);
        }
        if (mhs.ipk < current.mahasiswa.ipk) {
            current.left = addRekursifHelper(current.left, mhs);
        } else if (mhs.ipk > current.mahasiswa.ipk) {
            current.right = addRekursifHelper(current.right, mhs);
        }
        return current;
    }

    public void cariMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong!");
            return;
        }
        Node03 current = root;
        // Node paling kiri pada BST adalah nilai terkecil
        while (current.left !=  null) {
            current = current.left;
        }
        System.out.print("Mahasiswa dnegan IPK terkecil: ");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree kosong!");
            return;
        }
        Node03 current = root;
        // Node paling kanan pada BST adalah nilai terbesar
        while (current.right != null) {
            current = current.right;
        }
        System.out.print("Mahasiswa dengan IPK Terbesar: ");
        current.mahasiswa.tampilInformasi();
    }

    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        System.out.println("Daftar Mahasiswa dengan IPK di atas " + ipkBatas + ":");
        tampilIPKdiAtasHelper(root, ipkBatas);
    }

    private void tampilIPKdiAtasHelper(Node03 node, double ipkBatas) {
        if (node != null) {
            tampilIPKdiAtasHelper(node.left, ipkBatas);
            if (node.mahasiswa.ipk > ipkBatas) {
                node.mahasiswa.tampilInformasi();
            }
            tampilIPKdiAtasHelper(node.right, ipkBatas);
        }
    }
}
