package homework_20;

public class MyArrayTest {
    public static void main(String[] args) {
        MyArray<Number> integerArray = new MyArray();
        for(int i = 0; i < 10; i++) {
            integerArray.add(i + 3);
        }
        integerArray.printMyArray();
        integerArray.binarySearch(3);
        integerArray.remove(0);
        integerArray.remove(3);
        integerArray.printMyArray();
        integerArray.trimToSize();
        integerArray.printMyArray();

        MyArray<Float> floatArray = new MyArray();
        for(int i = 0; i < 10; i++) {
            floatArray.add(i + 1f);
        }
        floatArray.printMyArray();
        floatArray.binarySearch(5.0f);

        MyArray<Number> integerArray2 = new MyArray();
        for(int i = 0; i < 10; i++) {
            integerArray2.add(i + 7);
        }

        Number unionArray[] = integerArray.unionArrays(floatArray.getMas());    // first version
        for (Number eachElement : unionArray) {
            System.out.print(" " + eachElement);
        }
        System.out.println();

        integerArray.unionArraysAsArrayObjects(floatArray);       // second version
        integerArray.printMyArray();

        integerArray.unionArraysAsArrayObjects(integerArray2);
        integerArray.printMyArray();

        System.out.println(integerArray.getMin());
        System.out.println(integerArray.getMax());
    }
}

