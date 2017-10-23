package JDK.genericity;

import java.util.ArrayList;
import java.util.List;

public class FruitTest {
    static <T> void write(List<T> list, T t) {
        list.add(t);
    }

    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        fruits.add(new Apple());
        FruitTest.write(fruits, new Apple());

        Apple apple = (Apple) fruits.get(0);
    }
}
