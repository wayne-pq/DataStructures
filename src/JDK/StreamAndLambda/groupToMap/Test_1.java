package JDK.StreamAndLambda.groupToMap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by panqian on 2017/2/28.
 */
public class Test_1 {

    public static void main(String[] args) {
        ArrayList<Group> groups = new ArrayList<>();

        groups.add(new Group("1321813", "88", "panqian01"));
        groups.add(new Group("1321813", "100", "panqian02"));
        groups.add(new Group("1321814", "99", "panqian03"));
        groups.add(new Group("1321815", "70", "panqian04"));


        //所有人按班级分组
        Map<String, List<Group>> collect = groups.stream().collect(Collectors.groupingBy(Group::getClasses));
        Set<String> strings = collect.keySet();
        for (String s : strings) {
            System.out.println(s + ":");
            collect.get(s).forEach(x -> System.out.println(x.getName()));
        }

        System.out.println("---------------------------------");

        //所有人按班级分组（名字用,连接）
        Map<String, String> collect4 = groups.stream().collect(Collectors.groupingBy(Group::getClasses, Collectors.mapping(Group::getName, Collectors.joining(","))));

        Set<String> strings4 = collect4.keySet();
        for (String s : strings4) {
            System.out.println(s + ":");
            System.out.println(collect4.get(s));
        }

        System.out.println("---------------------------------");

        //按成绩90分为界限  进行分组
        Map<Boolean, List<Group>> collect1 = groups.stream().collect(Collectors.partitioningBy(x -> Integer.valueOf(x.getNum()) > 90));
        Set<Boolean> strings1 = collect1.keySet();
        for (Boolean s : strings1) {
            System.out.println(s + ":");
            collect1.get(s).forEach(x -> System.out.println(x.getName()));
        }

        System.out.println("---------------------------------");

        //计算每个班的班级人数
        Map<String, Long> collect2 = groups.stream().collect(Collectors.groupingBy(Group::getClasses, Collectors.counting()));
        Set<String> strings2 = collect2.keySet();
        for (String s : strings2) {
            System.out.println(s + ":");
            System.out.println(collect2.get(s));
        }

        System.out.println("---------------------------------");

        //计算每个班的最高分
        Map<String, Optional<Group>> collect3 = groups.stream().collect(Collectors.groupingBy(Group::getClasses, Collectors.maxBy(new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                if (Integer.valueOf(o1.getNum()) > Integer.valueOf(o2.getNum()))
                    return 1;
                return -1;
            }
        })));
        Set<String> strings3 = collect3.keySet();
        for (String s : strings3) {
            System.out.println(s + ":");
            Optional<Group> group = collect3.get(s);
            group.ifPresent(x -> System.out.println(x.getName()));
        }


    }
}
