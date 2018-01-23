package JDK.Array;


import java.util.ArrayList;

public class Array_2 {
    public static void main(String[] args) {
//        数组的引用可以用泛型
        ArrayList<? extends Number>[] list = null;

        ArrayList<Integer> integers = new ArrayList<>();

        list[0] = integers;

        Integer integer = integers.get(0);

    }
}
