package JDK.reference;


import java.util.WeakHashMap;

/**
 * 弱引用情况下，WeakHashMap会对没有强引用的Key进行清理
 */
public class WeakHashMapTest {


    public static void main(String[] args) {
        WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
        WeakHashMap<Key, Value> map = new WeakHashMap<>();

        System.out.println("map size :" + map.size());

        for (int i = 0; i < 10000000; i++) {
            map.put(weakHashMapTest.new Key(i), weakHashMapTest.new Value(i));
        }

        System.out.println("map size :" + map.size());


    }

    private class Elememt {
        int i;

        public Elememt(int i) {
            this.i = i;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize class : " + this.getClass() + " i:" + i);
        }

        @Override
        public String toString() {
            return "Elememt{" +
                    "i=" + i +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Elememt elememt = (Elememt) o;

            return i == elememt.i;
        }

        @Override
        public int hashCode() {
            return i;
        }
    }


    public class Key extends Elememt {

        public Key(int i) {
            super(i);
        }
    }


    public class Value extends Elememt {

        public Value(int i) {
            super(i);
        }
    }


}
