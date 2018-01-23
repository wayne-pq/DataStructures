package 排序算法;

import java.util.Arrays;

/**
 * 插入排序 时间复杂度 平均，最坏情况 n^2  最好情况 n
 * 
 * @author panqian
 * @date 2016年12月24日 下午10:30:46
 */
public class InsertSort {

	public static void insertSort(int[] arr, String a) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				int x = arr[i];
				int y = i - 1;
				while (x < arr[y]) {
					arr[y + 1] = arr[y];
					if (--y < 0)
						break;
				}

				arr[y + 1] = x;
			}
		}

		a += "f";
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 4, 1, 2 };

		String a = "asd";
		InsertSort.insertSort(arr, a);

		System.out.println(Arrays.toString(arr));

		System.out.println(a);

	}
}
