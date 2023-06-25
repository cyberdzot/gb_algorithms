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
        Node new_node = new Node(); // создали новую пустую ноду
        new_node.value = value; // положили значение в новую ноду

        // привяжем нашу новую ноду к концу списка, если таков существует
        if (head == null) { // если головы нету, то список не существует - обозначаем ему начало и конец
            head = new_node;
            tail = new_node;
        } else { // если голова найдена, то список есть - паркуем нашу ноду в конец
            tail.next = new_node; // даём знать хвосту - что у него появился сосед справа
            new_node.prev = tail; // даём знать новой ноде - что у неё появился сосед слева, подружили...
            tail = new_node; // пусть хвостом будет новая нода, чтобы дальше можно было так же дружить остальных
        }
    }

    /**
     * Добавление значения в начало списка
     * @param value
     */
    public void addFirst(int value) {
        Node new_node = new Node(); // создали новую пустую ноду
        new_node.value = value; // положили значение в новую ноду

        // привяжем нашу новую ноду к началу списка, если таков существует
        if (head == null) { // если головы нету, то список не существует - обозначаем ему начало
            head = new_node;
            tail = new_node;
        } else { // если голова найдена, то список есть - паркуем нашу ноду в начало
            head.prev = new_node; // даём знать голове - что у неё появился сосед слева
            new_node.next = head; // даём знать новой ноде - что у неё появился сосед справа, подружили...
            head = new_node; // пусть головой будет новая нода, чтобы дальше можно было так же дружить остальных
        }
    }

    /**
     * Разворот двусвязного списка через цикл
     */
    public void revert() {
        Node current_node = head; // начинаем с головы
        while (current_node != null) {
            Node next = current_node.next; // кешируем соседние ноды, чтобы не сломался порядок перезаписи
            Node prev = current_node.prev;
            current_node.next = prev; // меняем местами соседей
            current_node.prev = next;
            if (prev == null) {
                tail = current_node;
            }
            if (next == null) {
                head = current_node;
            }
            current_node = next; // переход на следующую ноду
        }
    }
}
