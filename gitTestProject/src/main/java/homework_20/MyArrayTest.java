package homework_20;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        for(int i = 0; i < 10; i++) {
            myArray.add(i);
        }
        System.out.println(myArray);
        myArray.add("tra");
        System.out.println(myArray);
        myArray.remove(2);
        System.out.println(myArray);
        myArray.trimToSize();
        myArray.printMyArray();

        MyArrayObject myArrayObject = new MyArrayObject();
        for(int i = 0; i < 10; i++) {
            myArrayObject.add(i);
        }
        System.out.println(myArrayObject);
        myArrayObject.add("tra");
        System.out.println(myArrayObject);
        myArrayObject.remove(2);
        System.out.println(myArrayObject);
        myArrayObject.trimToSize();
        myArrayObject.printMyArray();
    }
}

