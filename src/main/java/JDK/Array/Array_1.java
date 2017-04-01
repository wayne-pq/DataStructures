package JDK.Array;

import java.util.Arrays;

/**
 * Created by panqian on 2017/3/13.
 */
public class Array_1 {
    public static void main(String[] args) {
        //当创建一个数组对象时，实际上就是创建了一个引用数组，每个引用都会初始化为null，如果试图使用一个还是null的引用，会报错
        String[] str = new String[5];
        System.out.println(Arrays.toString(str));

        //如果是基本类型，会默认置为0
        int[] str1 = new int[5];
        System.out.println(Arrays.toString(str1));

        int i = 1;
        Man man = new Man();
        Man man1 = new Man();
        man.age = 1;
        man1.age = 0;

//        System.out.println("i:" + i + " man:" + man.age);
//        Array_1.sum(i, man);
//        System.out.println("i:" + i + " man:" + man.age);

        System.out.println(" man:" + man.age + " man1:" + man1.age);
        Array_1.sum1(man, man1);
        System.out.println(" man:" + man.age + " man1:" + man1.age);
    }

    //讨论基本数据类型是值拷贝，非基本数据类型是引用的拷贝
    public static void sum(int a, Man l) {
        a++;
        l.age = 2;
    }

    //反驳非基本数据类型是 引用传值，正确的说是  引用的拷贝
    public static void sum1(Man l, Man l1) {
        Man temp = l;
        l = l1;
        l1 = temp;
    }

}
