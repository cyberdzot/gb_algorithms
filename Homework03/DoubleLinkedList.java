package Homework03;

// null <-> Node1 <-> Node2 <-> Node3 <-> null
// двусвязный список
public class DoubleLinkedList {
    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node prev;

        @Override
        public String toString() {
            return "Node{" +
                    "value = " + value +
                    ", next = " + next +
                    ", prev = " + prev +
                    '}';
        }
    }
    
    /**
     * Вывод списка в консоль
     */
    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * Добавление значения в конец списка
     * @param value
     */
    public void addNext(int value) {
        Node newNode = new Node(); // создали новую пустую ноду
        newNode.value = value; // положили значение в новую ноду

        // привяжем нашу новую ноду к концу списка, если таков существует
        if (head == null) { // если головы нету, то список не существует - обозначаем ему начало и конец
            head = newNode;
            tail = newNode;
        } else { // если голова найдена, то список есть - паркуем нашу ноду в конец
            tail.next = newNode; // даём знать хвосту - что у него появился сосед справа
            newNode.prev = tail; // даём знать новой ноде - что у неё появился сосед слева, подружили...
            tail = newNode; // пусть хвостом будет новая нода, чтобы дальше можно было так же дружить остальных
        }
    }

    /**
     * Добавление значения в начало списка
     * @param value
     */
    public void addFirst(int value) {
        Node newNode = new Node(); // создали новую пустую ноду
        newNode.value = value; // положили значение в новую ноду

        // привяжем нашу новую ноду к началу списка, если таков существует
        if (head == null) { // если головы нету, то список не существует - обозначаем ему начало
            head = newNode;
            tail = newNode;
        } else { // если голова найдена, то список есть - паркуем нашу ноду в начало
            head.prev = newNode; // даём знать голове - что у неё появился сосед слева
            newNode.next = head; // даём знать новой ноде - что у неё появился сосед справа, подружили...
            head = newNode; // пусть головой будет новая нода, чтобы дальше можно было так же дружить остальных
        }
    }

    /**
     * Разворот двусвязного списка через цикл
     */
    public void revert() {
        Node currentNode = head; // начинаем с головы
        while (currentNode != null) {
            Node next = currentNode.next; // кешируем соседние ноды, чтобы не сломался порядок перезаписи
            Node prev = currentNode.prev;
            currentNode.next = prev; // меняем местами соседей
            currentNode.prev = next;
            if (prev == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next; // переход на следующую ноду
        }
    }
}
