package 队列;

import java.util.ArrayDeque;
/**
 * 队列  也是一种表 先进先出 就像平常生活中的排队  
 * 使用队列时插入在一端  删除在另一端
 * ArrayDeque 是队列的数组实现
 * @author panqian
 *
 */
public class ArrayDequeTest{

	public static void main(String[] args) {
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		for (int i = 0; i < 10; i++) {
			deque.offer(i);
		}
		
		while(!deque.isEmpty()){
			System.out.println(deque.poll());
		}
	}
}
