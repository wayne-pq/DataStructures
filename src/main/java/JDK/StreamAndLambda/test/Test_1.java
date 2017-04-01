package JDK.StreamAndLambda.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by panqian on 2017/3/1.
 */
public class Test_1 {

    //查找前4个最大的字符串
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("She");
        strings.add("is");
        strings.add("yes");
        strings.add("well");
        strings.add("nothing");
        strings.add("fine");
        strings.add("a");

        List<String> collect = strings.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? -1 : 1;
            }
        }).peek(x -> System.out.println(x)).limit(4).collect(Collectors.toList());

        System.out.println(collect.toString());

    }
}
