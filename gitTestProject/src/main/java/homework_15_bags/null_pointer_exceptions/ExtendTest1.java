package homework_15_bags.null_pointer_exceptions;

public class ExtendTest1 {

    public static void main(String[] args) {
        new Child();
    }
}

abstract class Parent {
    public Parent() {
        init();
    }

    public abstract void init();
}


class Child extends Parent {
    private String mTitle = null;

    public Child() {
        init();                                     // the code was changed
        System.out.println(mTitle.toString());
    }

    public void init() {
        mTitle = "It' a test";
    }
}