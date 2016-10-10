package 引论;

/**
 * 递归计算 定义一个函数 f(x) = 2f(x-1) + x² 且 f(0) = 0
 * 
 * @author panqian
 *
 */
public class RecursiveDemo01 {
	public static void main(String[] args) {
		System.out.println(f(0));
		System.out.println(f(1));
		System.out.println(f(2));
	}

	public static int f(int x) {
		if (x == 0)
			return 0;
		else
			return 2 * f(x - 1) + x * x;
	}
}
