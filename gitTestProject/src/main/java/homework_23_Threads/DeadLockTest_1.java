package homework_23_Threads;

public class DeadLockTest_1 {
    private static Object object1 = new Object();
    private static Object object2 = new Object();
    private static boolean ready = false;

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
                    if (!ready) {
                        object1.wait();
                    }
                    System.out.println("MyThreadFirst hold object2");
                    synchronized (object2) {
                        System.out.println("MyThreadFirst INSIDE object2");
                    }
                }
            }catch (Exception e) {

            }
        }
    }

    static class MyThreadSecond extends Thread {
        public void run() {
            try {
                System.out.println("MyThreadSecond hold object2");
                synchronized (object2) {
                    System.out.println("MyThreadSecond hold object1");
                    synchronized (object1) {
                        ready = true;
                        System.out.println("MyThreadSecond INSIDE object1");
                        object1.notifyAll();
                    }
                }
            }catch (Exception e) {

            }
        }
    }
}