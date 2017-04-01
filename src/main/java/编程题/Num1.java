package 编程题;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 有N个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * 
 * 代码还有改进空间，主要因为不知道多少个数，所以需要用到递归，一开始想用treeset来去除重复，但是treeset是 去重 且 排好序的，不符合要求。
 * 
 * @author panqian
 *
 */
public class Num1 {

	public LinkedList<Integer> calculate(int[] strs) {

		int deep = strs.length;

		LinkedList<Integer> set = new LinkedList<Integer>();

		LinkedList<Integer> indexs = new LinkedList<Integer>();

		recursion(deep, set, strs, indexs);

		return set;
	}

	public void recursion(int deep, LinkedList<Integer> set, int[] strs, LinkedList<Integer> indexs) {
		if (deep > 1) {
			for (int i = 0; i < strs.length; i++) {

				// while((deep-1)!=indexs.size())
				if (strs.length - deep + 1 == indexs.size())
					indexs.removeLast();

				if (indexs.contains(i))
					continue;
				else
					indexs.add(i);

				LinkedList<Integer> indexss = new LinkedList<Integer>();
				indexss.addAll(indexs);
				recursion(deep - 1, set, strs, indexss);
			}
		} else if (deep == 1) {
			LinkedList<Integer> indexss = new LinkedList<Integer>();
			for (int i = 0; i < strs.length; i++) {
				indexss.clear();
				indexss.addAll(indexs);

				if (indexss.contains(i))
					continue;
				else
					indexss.add(i);

				int index_deep = indexss.size();
				int sum = strs[indexss.removeFirst()];
				int k = 1;
				while (index_deep > 1) {
					k *= 10;
					sum += k * strs[indexss.removeFirst()];
					index_deep--;
				}
				set.add(sum);
			}
		}
	}

	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();

		Num1 num1 = new Num1();
		LinkedList<Integer> calculate = num1.calculate(new int[] { 1, 2, 3, 4, 5, 6, 7 });

		long end1 = System.currentTimeMillis();
		System.out.println("NUM01 v1.0运行时间：" + (end1 - start1) + "毫秒");// 应该是end
																		// -
																		// start

		Collections.sort(calculate, new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				return (x < y) ? -1 : ((x == y) ? 0 : 1);
			}
		});
		System.out.println("能组成 " + calculate.size() + " 个组合");
		System.out.println(calculate);

	}

}
