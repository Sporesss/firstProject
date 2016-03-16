package homework_21_Map;

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


        myMap.deleteMapObject(1);   // first version
        myMap.deleteMapObjectWithoutIterator(56);   // second version
        System.out.println(myMap);

        Iterator iterator = myMap.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() -->  " + iterator.next());
        }
    }
}
