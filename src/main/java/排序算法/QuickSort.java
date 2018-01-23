package 排序算法;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 快速排序 时间复杂度 平均，最好 n㏒₂ⁿ 最坏n^2
 * 
 * @author panqian
 * @date 2016年12月22日 下午11:50:46
 */
public class QuickSort {

	public static int quick(int[] arr, int low, int high) {
		int key = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= key)
				high--;
			int tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
			while (low < high && arr[low] <= key)
				low++;
			tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		}
		return low;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int key = QuickSort.quick(arr, low, high);
			QuickSort.quickSort(arr, low, key - 1);
			QuickSort.quickSort(arr, key + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 5, 4 };

		QuickSort.quickSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

	}
}
