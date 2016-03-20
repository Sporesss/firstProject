package homework_22_bugfixing;

public class Problem_7 {
    private A objA = new A();    //was fixed
    private B objB = new B();    //was fixed
    class A {
        private int aValue;
        private B bValue = null;

        public A() {
            aValue = 0;
            bValue = objB;       //was fixed
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
            aInstance = objA;   //was fixed
        }

        @Override
        public String toString() {
            return "";
        }
    }

    public static void main(String[] args) {
        A obj = new Problem_7().new A();
        System.out.println(obj.toString());
    }

}
