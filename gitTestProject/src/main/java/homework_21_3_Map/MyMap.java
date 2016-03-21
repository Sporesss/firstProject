package homework_21_3_Map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class MyMap<K, V> implements Iterable<MyMap.MyEntry<K, V>>, Iterator<MyMap.MyEntry<K, V>> {

    private static final int CAPACITY = 5;
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
        private MyEntry<K, V> nextEntry;
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
            int index = indexFor(newPositionHash);
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
        int hashForRemove = hash(key);
        int index = indexFor(hashForRemove);

        if (elements[index].key.equals(key)) {
            elements[index] = elements[index].nextEntry;
        } else {
            MyEntry<K, V> previousElement = null;
            MyEntry<K, V> thisElement = elements[index];
            while (thisElement.getNextEntry() != null && !thisElement.getKey().equals(key)) {
                previousElement = thisElement;
                thisElement = thisElement.getNextEntry();
            }
            previousElement.setNextEntry(thisElement.getNextEntry());
        }
    }

    public void removeByRecursion(K key) {
        int hashForRemove = hash(key);
        int index = indexFor(hashForRemove);
        MyEntry<K, V> previousElement = null;
        MyEntry<K, V> thisElement = elements[index];

        innerMethod(previousElement, thisElement, key, index);
    }

    private MyEntry<K, V> innerMethod(MyEntry<K, V> previousElement, MyEntry<K, V> thisElement, K key, int index) {
        if (previousElement == null && thisElement.getKey().equals(key)) {
            elements[index] = thisElement.getNextEntry();
        } else if (thisElement == null) {
            System.out.println("The 'key' doesn't exist.");
        } else if (previousElement != null && thisElement.getNextEntry() != null && thisElement.getKey().equals(key)) {
            previousElement.setNextEntry(thisElement.getNextEntry());
        } else {
            return innerMethod(thisElement, thisElement.getNextEntry(), key, index);
        }
        return thisElement;
    }

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

