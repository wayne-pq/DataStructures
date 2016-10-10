package 表.LinkedList的实现;

import java.util.Iterator;

public class MyLinkedListTest {
	public static void main(String[] args) {
		
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		

//		list.get(0);
//		list.get(1);
		list.get(9);
		
//		list.remove(1);
//		
//		list.set(0, 10);
//		
//		list.get(0);
//		list.get(1);
		
		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()){
			Integer next = iterator.next();
			if(next == 1)
				iterator.remove();
			else
				System.out.println(next);
		}
		
		
		
		//list.get(3);
		
		System.out.println();

//		for (int i = 0; i < list.size(); i++) {
//			if (i % 2 == 0)
//				list.set(i, -1);
//		}
//
//		list.trimToSize();
//
//		list.add(2, 100);
//		//list.clear();
//		System.out.println("使用for循环遍历：");
//		//第一种遍历
//		if (!list.isEmpty()) {
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i)+" ");
//			}
//		}
//
//		System.out.println("");
//		System.out.println("使用增强for循环遍历：");
//		//第二种遍历  内部原理就是迭代器
//		for(int i : list)
//			System.out.print(i+" ");
//		
//		
//		System.out.println("");
//		System.out.println("使用迭代器遍历：");
//		//第二种遍历  内部原理就是迭代器
//		Iterator<Integer> iterator = list.iterator();
//		
//		while(iterator.hasNext()){
//			int i = iterator.next();
//			if(i==100){
//				iterator.remove();
//			}else{
//				System.out.print(i+" ");
//			}
//		}
		
		

	}
}
