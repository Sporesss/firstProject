package homework_10.homework_10_bugs.bug_2_cast_exception;

import java.io.IOException;

public class ClassCastExceptionBug {

    public static void main(String[] args) throws IOException {

        A ab = new A();                 // fix #1
        if (ab instanceof B) {          // fix #1
            B bb = (B) ab;              // fix #1
            System.out.println(bb.a);   // fix #1
        }

        A ao = new B();           // fix #2
        B b = (B) ao;             // fix #2
        System.out.println(b.a);  // fix #2
    }
}

class A {

    int a = 10;

    public void doSomethimg() {
        System.out.println("class A");
    }

}

class B extends A {

    int a = 20;

    public void doSomethimg() {
        System.out.println("class B");
    }

}
