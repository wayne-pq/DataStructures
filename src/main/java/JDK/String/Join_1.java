package JDK.String;

/**
 * String 分隔符
 * Created by panqian on 2017/3/9.
 */
public class Join_1 {
    public static void main(String[] args) {
        String join = String.join(",", "my", "name", "is");
        System.out.println(join);

        //String 格式化
        System.out.println(String.format("%s  %.2f", "my", 12312.3213));

        //由于精度问题，double永远不会加上等于10
        for (double i = 0; i != 10; i += 0.1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
