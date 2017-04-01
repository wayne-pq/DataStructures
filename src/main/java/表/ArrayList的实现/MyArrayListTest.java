package 表.ArrayList的实现;

import java.util.Iterator;

public class MyArrayListTest {
	public static void main(String[] args) {

		MyArrayList<Integer> list = new MyArrayList<>();

		for (int i = 0; i < 12; i++) {
			list.add(i);
		}

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0)
				list.set(i, -1);
		}

		list.trimToSize();

		list.add(2, 100);
		//list.clear();
		System.out.println("使用for循环遍历：");
		//第一种遍历
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
		}

		System.out.println("");
		System.out.println("使用增强for循环遍历：");
		//第二种遍历  内部原理就是迭代器
		for(int i : list)
			System.out.print(i+" ");
		
		
		System.out.println("");
		System.out.println("使用迭代器遍历：");
		//第二种遍历  内部原理就是迭代器
		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()){
			int i = iterator.next();
			if(i==100){
				iterator.remove();
			}else{
				System.out.print(i+" ");
			}
		}
		
		list.clear();
		
		System.out.println();

	}
}
