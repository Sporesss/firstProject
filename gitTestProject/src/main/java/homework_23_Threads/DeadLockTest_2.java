package homework_23_Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest_2 {
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        MyThreadFirst myThreadFirst = new MyThreadFirst();
        MyThreadSecond myThreadSecond = new MyThreadSecond();
        myThreadFirst.start();
        myThreadSecond.start();
    }

    static class MyThreadFirst extends Thread {
        public void run() {
            try {
                System.out.println("MyThreadFirst hold object1");
                synchronized (object1) {
                    Thread.sleep(10);
                    System.out.println("MyThreadFirst hold object2");
                    if (lock.tryLock()) {
                        try {
                            synchronized (object2) {
                                System.out.println("MyThreadFirst INSIDE object2");
                        }
                    } finally {
                            lock.unlock();
                        }
                    }
                }
            }catch (Exception e) {

            }
        }
    }

    static class MyThreadSecond extends Thread {
        public void run() {
            try {
                System.out.println("MyThreadSecond hold object1");
                synchronized (object2) {
                    Thread.sleep(10);
                    System.out.println("MyThreadSecond hold object2");
                    if (lock.tryLock()) {
                        try {
                            synchronized (object1) {
                                System.out.println("MyThreadSecond INSIDE object1");
                            }
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }catch (Exception e) {

            }
        }
    }
}
