package 树.Set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
/**
 * List容器(LinkedList,ArrayList)查找效率比较低，因此Collections API提供两个附加容器Set，Map
 * 下面是查找性能对比
 * 
 * 1. HashSet是通过HashMap实现的,TreeSet是通过TreeMap实现的,只不过Set用的只是Map的key
 * 2. Map的key和Set都有一个共同的特性就是集合的唯一性.TreeMap更是多了一个排序的功能.
 *  
 * @author panqian
 *
 */
public class TreeTest {
	public static void main(String[] args) {
		TreeSet<Integer> string1 = new TreeSet<Integer>();
		ArrayList<Integer> string2 = new ArrayList<Integer>();
		LinkedList<Integer> string3 = new LinkedList<Integer>();
		
		for (int i = 0; i < 10000000; i++) {
			string1.add(i);
			string2.add(i);
			string3.add(i);
		}
		
		
		long start1 = System.currentTimeMillis();
		System.out.println(string2.contains(7345640));
		long end1 = System.currentTimeMillis();
		System.out.println("ArrayList运行时间：" + (end1 - start1) + "毫秒");//应该是end - start
		
		long start2 = System.currentTimeMillis();
		System.out.println(string3.contains(7345640));
		long end2 = System.currentTimeMillis();
		System.out.println("LinkedList运行时间：" + (end2 - start2) + "毫秒");//应该是end - start
		
		
		long start3 = System.currentTimeMillis();
		System.out.println(string1.contains(7345640));
        long end3 = System.currentTimeMillis();
        System.out.println("TreeSet运行时间：" + (end3 - start3) + "毫秒");//应该是end - start
		
        
		
	}
}
