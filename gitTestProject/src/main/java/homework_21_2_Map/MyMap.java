package homework_21_2_Map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MyMap<K, V> implements Iterable<MyMap.MyEntry<K, V>>, Iterator<MyMap.MyEntry<K, V>> {

    private static final int CAPACITY = 16;
    private int cursor;

    public Iterator<MyEntry<K, V>> iterator() {
        return this;
    }

    public boolean hasNext() {
        return cursor < elements.length;
    }

    public MyEntry<K, V> next() {
        return elements[cursor++];
    }

    public static class MyEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private MyEntry<K, V> nextEntry;//ссылка на следующий элемент(Олег -> Женя)
        private int hash;

        public MyEntry(K key, V value, MyEntry<K, V> nextEntry, int hash) {
            this.key = key;
            this.value = value;
            this.nextEntry = nextEntry;
            this.hash = hash;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public MyEntry<K, V> getNextEntry() {
            return nextEntry;
        }

        public void setNextEntry(MyEntry<K, V> nextEntry) {
            this.nextEntry = nextEntry;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyEntry<?, ?> myEntry = (MyEntry<?, ?>) o;

            if (hash != myEntry.hash) return false;
            if (key != null ? !key.equals(myEntry.key) : myEntry.key != null) return false;
            if (value != null ? !value.equals(myEntry.value) : myEntry.value != null) return false;
            return !(nextEntry != null ? !nextEntry.equals(myEntry.nextEntry) : myEntry.nextEntry != null);
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (nextEntry != null ? nextEntry.hashCode() : 0);
            result = 31 * result + hash;
            return result;
        }

        @Override
        public String toString() {
            return "MyEntry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", nextEntry=" + nextEntry +
                    ", hash=" + hash +
                    '}';
        }
    }


    private MyEntry<K, V> elements[];

    public MyMap(MyEntry<K, V>[] elements) {
        this.elements = elements;
    }

    public MyMap() {
        elements = new MyEntry[CAPACITY];
    }

    public void put(K key, V value) {
        if (key != null) {
            int newPositionHash = hash(key);
            System.out.println(" int newPositionHash = hash(key) " + newPositionHash);
            int index = indexFor(newPositionHash);
            System.out.println("index = " + index);
            MyEntry<K, V> element = elements[index];
            if (element != null && key.equals(element.key)
                    && (newPositionHash == element.hash)) {
                element.setValue(value);
            } else {
                createNewMyEntry(value, key, newPositionHash, element, index);
            }
        }
    }

    public void putForcibly(K key, V value, int newPositionHash) {
        if (key != null) {
            int index = indexFor(newPositionHash);
            System.out.println("index = " + index);
            MyEntry<K, V> element = elements[index];
            if (element != null && key.equals(element.key)
                    && (newPositionHash == element.hash)) {
                element.setValue(value);
            } else {
                createNewMyEntry(value, key, newPositionHash, element, index);
            }
        }
    }

    public void remove(K key) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                MyEntry<K, V> previousElement = null;
                MyEntry<K, V> thisElement = elements[i];
                do {
                    if (thisElement.getKey() == key && previousElement == null) {
                        thisElement = thisElement.getNextEntry();
                        elements[i] = thisElement;
                        break;
                    }
                    else if (thisElement.getKey() == key && previousElement != null) {
                        nextEntryFunction(elements[i], previousElement, thisElement);
                        break;
                    } else {
                        previousElement = thisElement;
                        thisElement = thisElement.getNextEntry();
                    }
                } while (thisElement != null);
            }
        }
    }

    private MyEntry<K, V> nextEntryFunction(MyEntry<K, V> entry, MyEntry<K, V> previousElement, MyEntry<K, V> thisElement) {
        if (entry.equals(thisElement)) {
            previousElement.setNextEntry(thisElement.getNextEntry());
            return entry;
        } else {
            return nextEntryFunction(entry.getNextEntry(), previousElement, thisElement);
        }
    }

//    public void deleteMapObjectWithoutIterator(K key) {     // second version
////        int hashForSearch = hash(key);
//        System.out.println("deleteMapObjectWithoutIterator -ENTERED!!!");
//        for (int i = 0; i < elements.length; i++) {
//            if (elements[i] != null) {
//                System.out.println("hash(key): " + hash(key));
////                System.out.println("hash(elements[i].getKey()) !!!!!!!!!!! " + hash(elements[i].getKey()));
//                System.out.println("elements[i].getHash()!!!!!!!!!!!!!!!!!!!!!!! " + elements[i].getHash());
//                System.out.println("_____________________________________________________________________________");
//            }
//
////            if (elements[i] != null && hash(elements[i].getKey()) == hash(key)) {
//            if (elements[i] != null && hash(key) == elements[i].getHash()) {
//                System.out.println("elements[i] --> " + elements[i]);
//                MyEntry<K, V> entry = elements[i];
//                entry = relinkAkaDelete(entry, key);
//                System.out.println("ENTRY!!!!!!!" + entry);
////                while (!elements[i].nextEntry.equals(null))
//            }
////            if (elements[i] != null && elements[i].getKey().equals(key) && elements[i].hash == hash(key)) {
////                elements[i] = null;
////            }
//        }
//    }

//    private MyEntry<K, V> relinkAkaDelete(MyEntry<K, V> entry, K key) {
//        if (!entry.equals(null) && entry.getKey().equals(key)) {
//            System.out.println("entry --> " + entry);
//            entry = entry.nextEntry;
//        } else {
//            return relinkAkaDelete(entry.nextEntry, key);
//        }
//        return entry;
//    }

    public void createNewMyEntry(V value, K key, int newPositionHash,
                                  MyEntry<K, V> element, int index) {
        MyEntry myEntry = new MyEntry(key, value, element, newPositionHash);
        elements[index] = myEntry;
    }


    private int indexFor(int newPositionHash) {
        return newPositionHash & (elements.length - 1);
    }

    private int hash(K key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    @Override
    public String toString() {
        return "MyMap{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}

