package homework_22_bugfixing;

public class Problem_7_2 {
    class A {
        private int aValue;
        private B bValue = null;

        public A() {
            aValue = 0;
            bValue = new B();
        }

        @Override
        public String toString() {
            return "";
        }
    }

    class B {
        private int bValue;
        private A aInstance = null;

        public B() {
            bValue = 10;
            aInstance = new A();
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public static void main(String[] args) {
        A obj = new Problem_7_2().new A();
        System.out.println(obj.toString());
    }

}
