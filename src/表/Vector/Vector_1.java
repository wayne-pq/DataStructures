package 表.Vector;

import java.util.Iterator;
import java.util.Vector;

/**
 * Vector 继承于AbstractList，实现了List, RandomAccess, Cloneable这些接口。
 * Vector 跟 Arraylist的区别是   前者线程安全  后者线程不安全
 * Created by panqian on 2017/2/13.
 */
public class Vector_1 {

    //遍历Vector，使用迭代器的访问方式最快，使用随机访问最慢。
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();


        long startTime;
        long endTime;

        for (int i = 0; i < 2000000; i++)
            vector.addElement(i);




        /////////////////////////////////


        startTime = System.currentTimeMillis();

        for (Integer i : vector) {
        }

        endTime = System.currentTimeMillis();

        System.out.println("增强for循环访问时间：" + (endTime - startTime) + "毫秒");

        ////////////////////////////////////

        startTime = System.currentTimeMillis();

        for (Iterator<Integer> iterator = vector.iterator();iterator.hasNext();) {
            iterator.next();
        }

        endTime = System.currentTimeMillis();

        System.out.println("迭代器访问时间：" + (endTime - startTime) + "毫秒");

        //////////////////////////////////

        startTime = System.currentTimeMillis();

        for (int i = 0; i < vector.size(); i++)
            vector.get(i);

        endTime = System.currentTimeMillis();

        System.out.println("随机访问时间：" + (endTime - startTime) + "毫秒");
    }
}
