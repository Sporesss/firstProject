package homework_24_BlockingQueue;


import homework_20.MyArray;

import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        MyArrayBlockingQueue myBlockingQueue = new MyArrayBlockingQueue(1);
        Producer producer = new Producer(myBlockingQueue);
        Consumer consumer = new Consumer(myBlockingQueue);

        producer.start();
        consumer.start();
    }

    static class Producer extends Thread {
        private MyArrayBlockingQueue myArrayBQ;

        public Producer(MyArrayBlockingQueue myArrayBQ) {
            this.myArrayBQ = myArrayBQ;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("put " + i);
                    myArrayBQ.put(i);
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        }
    }

    static class Consumer extends Thread {
        private MyArrayBlockingQueue myArrayBQ;

        public Consumer(MyArrayBlockingQueue myArrayBQ) {
            this.myArrayBQ = myArrayBQ;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("take " + myArrayBQ.take());
                }
            } catch (Exception e) {

            }
        }
    }
}
