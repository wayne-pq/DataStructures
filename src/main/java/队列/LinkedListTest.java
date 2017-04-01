package 队列;

import java.util.LinkedList;

/**
 * 这是队列的链表实现，不存在要考虑下标的问题，也不需要扩展数组空间
 * 
 * @author panqian
 *
 */
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			list.offer(i);
		}
		
		while (!list.isEmpty()) {
			System.out.println(list.poll());
		}
	}
}
