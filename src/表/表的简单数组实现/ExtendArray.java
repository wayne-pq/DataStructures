package 表.表的简单数组实现;

/**
 * 数组如何被扩展
 * 
 * 对表的所有操作都可以通过数组实现，但是对数组的操作开销较大，对数组插入删除可能会导致数组的整体移动（除非在数组最高处增删）
 * @author panqian
 *
 */
public class ExtendArray {

	public static void main(String[] args) {

		Integer[] arr = new Integer[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		System.out.print("arr:");
		
		for (int i : arr){
			if(i!=arr.length-1){
				System.out.print(i + ", ");
			}else{
				System.out.print(i);
			}
		}
		
		System.out.println();
		
		Integer[] newArr = new Integer[arr.length*2];

		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		
		System.out.print("newArr:");
		
		for(int i=0;i<newArr.length;i++){
			if(i!=newArr.length-1){
				System.out.print(newArr[i] + ", ");
			}else{
				System.out.print(newArr[i]);
			}
		}
	}
}
