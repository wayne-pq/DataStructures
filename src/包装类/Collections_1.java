package 包装类;

import java.util.*;

/**
 * Created by panqian on 2017/2/13.
 */
public class Collections_1 {

    public static void main(String[] args) {
        List<String> a = Collections.nCopies(3,"A");

//        a.remove(0);
        System.out.println(a);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println(list);

        List<String> subList = list.subList(0, 1);
        subList.clear();

        System.out.println(list);



        Set<String> a1 = Collections.singleton("a");

        List<String> strings = Collections.unmodifiableList(a);

        List<String> strings1 = Collections.synchronizedList(a);


    }
}
