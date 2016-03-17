package homework_21_2_Map;

import java.util.Iterator;

public class MyMapTest {
    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<Integer, String>();
        myMap.put(1, "Eugene");
        myMap.put(56, "Oleg");//ключики - любые
        System.out.println(myMap);
        myMap.put(1, "Oleg_new_value");//должен перезатереть старое значение - Eugene, смотрите ключик 1 -> 8 строчка
        myMap.put(5, "Pasha");
        System.out.println(myMap);
        myMap.putForcibly(6, "TEST nextEntry", 5);
        myMap.putForcibly(7, "TEST nextEntry 2!!!", 5);
        System.out.println(myMap);
//        myMap.putForcibly(7, "different hash", 4);
//        myMap.createNewMyEntry("TEST nextEntry", 5, );


//        myMap.deleteMapObject(5);   // first version
//        myMap.deleteMapObjectWithoutIteratorOld(7);   // second version
//        System.out.println(myMap);

        myMap.deleteMapObjectWithoutIterator(1);

        Iterator iterator = myMap.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() -->  " + iterator.next());
        }
    }
}
