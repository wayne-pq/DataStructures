package 表.LinkedList的实现;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

	/**
	 * 头节点
	 */
	Node<T> first;

	/**
	 * 尾节点
	 */
	Node<T> end;

	/**
	 * 此linkedlist的大小
	 */
	private int theSize;

	/**
	 * 对链表操作数进行监控
	 */
	private int modcount = 0;

	private Node<T> t;

	private static class Node<T> {

		public T t;
		public Node<T> pre;
		public Node<T> next;

		public Node(T t, Node<T> pre, Node<T> next) {
			super();
			this.t = t;
			this.pre = pre;
			this.next = next;
		}
	}

	public MyLinkedList() {
		clear();
	}

	/**
	 * 重新初始化数组
	 */
	public void clear() {

		first = new Node<T>(null, null, null);
		end = new Node<T>(null, first, null);

		first.next = end;

		theSize = 0;

		modcount++;
	}

	/**
	 * 
	 * @return 返回数组大小
	 */
	public int size() {
		return theSize;
	}

	/**
	 * 判断是否为空
	 * 
	 * @return 空为true 否则为false
	 */
	public boolean isEmpty() {
		return theSize == 0;
	}

	public boolean add(T t) {
		return add(size(), t);
	}

	public boolean add(int idx, T t) {
		checkPositionIndex(idx);
		return addBefore(getNode(size()), t);
	}

	public boolean addBefore(Node<T> p, T t) {
		Node<T> newNode = new Node<T>(t, p.pre, p);
		p.pre = newNode;
		newNode.pre.next = newNode;
		theSize++;
		modcount++;
		return true;
	}

	public T get(int idx) {
		checkElementIndex(idx);
		return getNode(idx).t;
	}

	public Node<T> getNode(int idx) {
		Node<T> t;

		if (idx < size() / 2) {
			t = first;
			for (int i = 0; i <= idx; i++)
				t = t.next;
		} else {
			t = end;
			for (int i = size(); i > idx; i--)
				t = t.pre;
		}

		return t;
	}

	public T set(int idx,T t) {
		checkElementIndex(idx);
		T old = getNode(idx).t;
		getNode(idx).t = t;
		return old;
	}
	
	public T remove(int idx) {
		checkElementIndex(idx);
		return remove(getNode(idx));
	}

	public T remove(Node<T> t) {
		t.next.pre = t.pre;
		t.pre.next = t.next;
		
		theSize--;
		modcount++;
		
		return t.t;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyLinkedList.LinkedListIterator();
	}
	
	public class LinkedListIterator implements Iterator<T>{

		private Node<T> currentNode = first;
		private int expectedModCount = modcount;
		private boolean okToRemove = false;
		
		
		@Override
		public boolean hasNext() {
			return currentNode.next != end;
		}

		@Override
		public T next() {
			if(modcount != expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			currentNode = currentNode.next;
			okToRemove = true;
			return currentNode.t;
		}

		@Override
		public void remove() {
			if(modcount != expectedModCount){
				throw new ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			
			MyLinkedList.this.remove(currentNode);
			
			currentNode = currentNode.pre;
			
			okToRemove = false;
			
			expectedModCount++;
		}
		
	}

	private void checkElementIndex(int idx) {
		if (!isElementIndex(idx))
			throw new IndexOutOfBoundsException("index:" + idx + "数组越界");
	}

	private void checkPositionIndex(int idx) {
		if (!isPositionIndex(idx))
			throw new IndexOutOfBoundsException("index:" + idx + "数组越界");
	}

	/**
	 * Tells if the argument is the index of an existing element.
	 */
	private boolean isElementIndex(int index) {
		return index >= 0 && index < size();
	}

	/**
	 * Tells if the argument is the index of a valid position for an iterator or
	 * an add operation.
	 */
	private boolean isPositionIndex(int index) {
		return index >= 0 && index <= size();
	}

}
