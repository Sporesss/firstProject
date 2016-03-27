package homework_24_BlockingQueue;

import java.util.Arrays;

public class MyArrayBlockingQueue {

    private Object array[];
    private int currentPosition;
    private boolean isAvailable;

    public MyArrayBlockingQueue(int capacity) {
        this.array = new Object[capacity];
        currentPosition = 0;
    }

    synchronized public void put(Object object) throws InterruptedException {
        while (isAvailable) { wait(); }
        isAvailable = true;
        array[currentPosition] = object;
        currentPosition++;
        notifyAll();
    }

    synchronized public Object take() throws InterruptedException {
        while (!isAvailable) { wait(); }
        Object returnedObject = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = null;
        isAvailable = false;
        currentPosition--;
        notifyAll();
        return returnedObject;
    }

    @Override
    public String toString() {
        return "MyArrayBlockingQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
