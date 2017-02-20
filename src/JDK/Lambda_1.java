package JDK;

import java.util.*;
import java.util.function.IntBinaryOperator;

/**
 * Created by panqian on 2017/2/20.
 */
public class Lambda_1 {

    public static void main(String[] args) {

        //传统创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("传统创建线程");
            }
        }).start();

        //使用lambda表达式
        new Thread(() -> {
            System.out.println("lambda表达式");
        }).start();

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);

        System.out.println("排序前： " + list.toString());

        Collections.sort(list, (Integer x, Integer y) -> {
            return x > y ? 1 : -1;
        });


        System.out.println("排序后： " + list.toString());


        //方法引用

        //对象::实例方法
        //类::静态方法

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);

        System.out.println("排序前： " + list1.toString());

        //::前面是类，后面是方法，等同于 Integer.compare(x,y)
        list1.sort(Integer::compare);

        System.out.println("排序前： " + list1.toString());

    }
}
