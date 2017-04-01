package 引论;

/**
 * 假设当前的I/O流只能在控制台输出一个数字,如何打出76234 ？
 * 
 * @author panqian
 *
 */
public class RecursiveDemo02 {
	public static void main(String[] args) {
		output(76234);
	}

	public static void output(int x) {
		if (x >= 10) {
			output(x / 10);
		}
		System.out.print(x % 10);
	}
}
