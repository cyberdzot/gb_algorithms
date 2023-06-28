package Homework03;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addNext(3);
        dll.addNext(4);
        dll.addNext(5);

        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);

        dll.printList();
        dll.revert();
        dll.printList();
    }
}
