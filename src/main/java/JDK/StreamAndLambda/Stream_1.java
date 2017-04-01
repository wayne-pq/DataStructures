package JDK.StreamAndLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * jdk Stream api
 * Created by panqian on 2017/2/21.
 */
public class Stream_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int) (Math.random() * 100));
        }

        int count = 0;
        for (int i : list) {
            if (i > 50)
                count++;
        }

        System.out.println("传统方法 列表中大于50的数有" + count + "个");

        long streamCount = list.stream().filter((x) -> x > 50).count();

        System.out.println("Stream流 列表中大于50的数有" + streamCount + "个");

        //filter 是根据规则进行过滤（决定该元素会不会过滤）
        List<Integer> collect = list.stream().filter((x) -> x > 50).collect(Collectors.toList());

        System.out.println("返回的集合个数：" + collect.size());

        String[] str = {"my", "name", "is", "panqian"};
        List<String> strings = Arrays.asList(str);
        //map 是根据规则对该元素进行处理，返回的是处理的结果
        //字符串首字母大写
        List<String> collect1 = strings.stream().map(x -> {
            char[] chars = x.toCharArray();
            chars[0] -= 32;
            return String.valueOf(chars);
        }).collect(Collectors.toList());


        System.out.println("返回处理后的集合：" + collect1);

        //并行执行
        List<Integer> collect2 = list.parallelStream().filter((x) -> x > 50).collect(Collectors.toList());

        //reduce 将stream中的元素做聚合操作，比如所有数相加
        Optional<Integer> addAll = list.parallelStream().reduce((x, y) -> x + y);

        System.out.println("相加的和为 : " + addAll.get());

        //模拟累加器
        int sum = strings.stream().mapToInt(x -> x.length()).sum();
        System.out.println("字符串总长度" + sum);
    }
}
