package homework_20;

import java.util.Arrays;

public class MyArray <T extends Number> {
    private final static int CAPACITY = 10;
    private T mas[];
    private int currentActualPosition;

    public MyArray() {
        mas = (T[]) new Number [CAPACITY];
        currentActualPosition = 0;
    }

    public T[] getMas() {
        return mas;
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

    public void binarySearch(T elementForSearch) {
        mas = Arrays.copyOf(mas, currentActualPosition);  // in fact it's "trimToSize" method
        int min = 0;
        int max = mas.length - 1;
        int index = innerSideOfBinarySearch(mas, min, max , elementForSearch);
        System.out.println("index = " + index);
    }

    private int innerSideOfBinarySearch(T mas[], int min, int max, T elementForSearch) {
        int averageIndex = (max - min) / 2 + min;
        if (elementForSearch.doubleValue() < mas[averageIndex].doubleValue()) {
            return innerSideOfBinarySearch(mas, min, averageIndex, elementForSearch);
        }
        if (elementForSearch.doubleValue() > mas[averageIndex].doubleValue()) {
            return innerSideOfBinarySearch(mas, averageIndex, max, elementForSearch);
        }
    return averageIndex;
    }

    public T[] unionArrays(T masForUnion[]) {                                     // first version
        if ((mas.length - currentActualPosition) < masForUnion.length) {
            mas = Arrays.copyOf(mas, currentActualPosition + masForUnion.length);
        }
        System.arraycopy(masForUnion, 0, mas, currentActualPosition, masForUnion.length);
        currentActualPosition += masForUnion.length;
        return mas;
    }

    public void unionArraysAsArrayObjects(MyArray arrayForUnion) {              // second version
        if ((mas.length - currentActualPosition) < arrayForUnion.getMas().length) {
            mas = Arrays.copyOf(mas, currentActualPosition + arrayForUnion.getMas().length);
        }
        System.arraycopy(arrayForUnion.getMas(), 0, mas, currentActualPosition, arrayForUnion.getMas().length);
        currentActualPosition += arrayForUnion.getMas().length;
    }

    public T getMin() {
        T min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].doubleValue() < min.doubleValue()) {
                min = mas[i];
            }
        }
        return min;
    }

    public T getMax() {
        T max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].doubleValue() > max.doubleValue()) {
                max = mas[i];
            }
        }
        return max;
    }

    public void printMyArray() {
        System.out.println(Arrays.toString(mas));
    }
}

