package 表.CollectionApI中的表;

import java.util.ArrayList;
import java.util.List;
/**
 * ListIterator拓展了Iterator的功能  能够 利用set设置新值，从后往前遍历 等新功能
 * @author panqian
 *
 */
public class ListIterator {

	public static void run(List list){
		java.util.ListIterator<Integer> listIterator = list.listIterator();
		
		while(listIterator.hasNext()){
			if(listIterator.next()%2==0){
				listIterator.set(-1);
				listIterator.remove();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		java.util.LinkedList<Integer> list2 = new java.util.LinkedList<Integer>();
		
		for(int i = 0;i<100000;i++){
			list.add(i);
			list2.add(i);
		}
			list.trimToSize();
		
			
			long start = System.currentTimeMillis();
			run(list);
	        long end = System.currentTimeMillis();
	        System.out.println("ArrayList运行时间：" + (end - start) + "毫秒");//应该是end - start
			
	        start = System.currentTimeMillis();
	        run(list2);
	        end = System.currentTimeMillis();
	        System.out.println("LinkedList运行时间：" + (end - start) + "毫秒");//应该是end - start
			
		
	}
}
