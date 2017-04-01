package 表.ArrayList的实现;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

	/**
	 * 默认初始化数组大小
	 */
	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * 存放的数据
	 */
	private T[] theItems;

	/**
	 * 此arraylist的大小
	 */
	private int theSize;

	public MyArrayList() {
		clear();
	}

	/**
	 * 重新初始化数组
	 */
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
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

	/**
	 * 缩小数组的空间为数组的实际长度，避免浪费空间
	 */
	public void trimToSize() {
		ensureCapacity(size());
	}

	/**
	 * 返回指定索引位置的数据
	 * 
	 * @param idx
	 * @return 返回指定数据
	 */
	public T get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException(idx);
		}
		return theItems[idx];
	}

	public T set(int idx, T newElement) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException("Index: " + idx + ", Size: " + size());
		}
		T old = theItems[idx];
		theItems[idx] = newElement;
		return old;
	}

	public boolean add(T t) {
		add(size(), t);
		return true;
	}

	public void add(int idx, T t) {

		if (theItems.length == size()) {
			ensureCapacity(size() * 2);
		}

		for (int i = size(); i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}

		theItems[idx] = t;
		theSize++;
	}

	/**
	 * 删除某元素
	 * 
	 * @param idx
	 * @return 返回被删除的元素
	 */
	public T remove(int idx) {

		T t = theItems[idx];

		for (int i = idx; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}

		theSize--;

		return t;
	}

	/**
	 * 当数组空间不够时，及时扩容
	 * 
	 * @param newCapacity
	 */
	private void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize)
			return;

		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];

		for (int i = 0; i < size(); i++) {
			theItems[i] = old[i];
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Itr();
	}

	private class Itr implements Iterator<T> {

		private int current = 0;

		//private MyArrayList<T> theList;

		public Itr() {
			//theList = list;
		}

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public T next() {
			return MyArrayList.this.get(current++);
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}

	}

}
