package 表.CollectionApI中的表;

import java.util.Iterator;
import java.util.List;

/**
 * ArrayList 与  LinkList 删除操作的性能对比
 * ArrayList 内部是数组结构，所以每次删除 整体结构需要重新排列，花费时间较长
 * LinkedList  内部是双链表结构，所以每次删除 整体结构不需要重新排列，花费时间较短
 * @author panqian
 *
 */
public class ArrayList {
	
	public static void run(List list){
		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()){
			if(iterator.next()%2==0){
				iterator.remove();
			}
		}
		
	}
	public static void main(String[] args) {
		java.util.ArrayList list = new java.util.ArrayList();
		java.util.LinkedList list2 = new java.util.LinkedList();
		
		for(int i = 0;i<100000;i++){
			list.add(i);
			list2.add(i);
		}
		
		//缩小数组的空间为数组的实际长度，避免浪费空间
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
