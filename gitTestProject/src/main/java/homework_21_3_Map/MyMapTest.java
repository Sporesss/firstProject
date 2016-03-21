package homework_21_3_Map;

import java.util.Iterator;

public class MyMapTest {
    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<Integer, String>();
        myMap.put(7, "Eugene");
        myMap.put(17, "Oleg 17");
        myMap.put(11, "Oleg 11");
        myMap.put(22, "Oleg 22");
        myMap.put(33, "Oleg 33");
        myMap.put(44, "Oleg 44");
        myMap.put(55, "Oleg 55");
        myMap.put(66, "Oleg 66");
        myMap.put(77, "Oleg 77");
        System.out.println(myMap);
        System.out.println();

        myMap.remove(77);

        myMap.removeByRecursion(100);

        Iterator iterator = myMap.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() -->  " + iterator.next());
        }
    }
}
