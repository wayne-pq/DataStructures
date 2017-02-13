package 排序算法;

import java.util.Arrays;

/**
 * 快速排序 时间复杂度 平均，最好 n㏒₂ⁿ 最坏n^2
 * 
 * @author panqian
 * @date 2016年12月22日 下午11:50:46
 */
public class QuickSort {

	public static int purtition(int[] arr, int low, int high) {
		int privotekey = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= privotekey)
				high--;
			int tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
			while (low < high && arr[low] <= privotekey)
				low++;
			tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		}
		return low;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int privotekey = QuickSort.purtition(arr, low, high);
			QuickSort.quickSort(arr, low, privotekey - 1);
			QuickSort.quickSort(arr, privotekey + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 4 };

		QuickSort.quickSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

	}
}
