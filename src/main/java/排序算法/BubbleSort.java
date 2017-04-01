 package 排序算法;

import java.util.Arrays;

/**
 * 冒泡排序   时间复杂度 平均，最坏情况 n^2  最好情况 n
 * @author panqian
 * @date 2016年12月22日 下午11:50:46
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr,StringBuffer buffer,StringBuffer buffer1) {

		buffer.append("123");
		
		buffer1 = buffer;
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = k;
				}
			}
		}
	}
	
	
	public static void main(String[] args){
		int []arr = {1,3,2,4,5};
		
		StringBuffer buffer = new StringBuffer();
		StringBuffer buffer1 = new StringBuffer();
		
		BubbleSort.bubbleSort(arr,buffer,buffer1);
		
		System.out.println(buffer);
		System.out.println(buffer1);
		
		System.out.println(Arrays.toString(arr));
		
	}
}
