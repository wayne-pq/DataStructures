package 排序算法;

import java.util.Arrays;

/**
 * 选择排序 时间复杂度 n^2
 * 
 * @author panqian
 * @date 2016年12月22日 下午11:50:46
 */
public class SelectSort {

	public static void selectSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int m = i;

			// 找最小值
			for (int j = m + 1; j < arr.length; j++) {
				if (arr[m] > arr[j]) {
					m = j;
				}
			}

			if (i != m) {
				int tmp = arr[i];
				arr[i] = arr[m];
				arr[m] = tmp;
			}

		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 4, 1, 2 };

		SelectSort.selectSort(arr);

		System.out.println(Arrays.toString(arr));

	}
}
