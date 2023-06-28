package Homework02;

public class Main {
    public static void main(String[] args) {
        int[] my_array = new int[] { 1, 8, 5, 2 };
        heapSort(my_array);
        for (int i = 0; i < my_array.length; i++) {
            System.out.print(my_array[i] + " ");
        }
    }

    public static void heapSort(int[] array) {
        // построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int heapSize, int rootIndex) {
        // инициализируем наибольший элемент как корень
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        // если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
