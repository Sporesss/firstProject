package homework_7.bug_4;

public class ArrayOutOfBoundException {
    public static void main(String... args) {

        int[] xArray = {1, 3, 4, 5};
        int[] yArray = {1, 3, 4, 5};


        arrayShow(xArray);
        arrayShow(yArray);

        A a = new A(xArray, yArray);
        a.createPolygon();

        System.out.println("Height = " + a.getHeight());
        System.out.println("Width = " + a.getWidth());

    }

    public static void arrayShow(int[] array) {
        for (int value : array) System.out.print(value + " ");
        System.out.println();
    }


}

