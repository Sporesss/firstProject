package homework_20;

import java.util.Arrays;

public class MyArray <T> {
    private final static int CAPACITY = 10;
    private T mas[];
    private int currentActualPosition;

    public MyArray() {
        mas = (T[]) new Object [CAPACITY];
        currentActualPosition = 0;
    }

    public void add(T newElement) {
        if (currentActualPosition >= mas.length) {
            mas = Arrays.copyOf(mas, mas.length + CAPACITY);
        }
        mas[currentActualPosition++] = newElement;
    }

    public void remove(int index) {
        int copyElementSize = mas.length - index - 1;
        System.arraycopy(mas, index + 1, mas, index, copyElementSize);
        mas[mas.length - 1] = null;
        currentActualPosition--;
    }

    public void trimToSize() {
        mas = Arrays.copyOf(mas, currentActualPosition);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < currentActualPosition; i++) {
            result.append(mas[i] + ", ");
        }
        result.append("]");
        return result.toString();
    }

    public void printMyArray() {
        System.out.println(Arrays.toString(mas));
    }
}

