package JDK;

/**
 * 带标签的break语句，可以退出指定循环
 * Created by panqian on 2017/2/17.
 */
public class For_1 {

    public static void main(String[] args) {

        for_1:
        for (int i = 0; i < 10; i++) {
            for_2:
            System.out.println("for_1 : " + i);
            for (int j = 0; j < 10; j++) {
                if (j == 4) {
                    System.out.println("for_2 : " + j);
                    break for_1;
                }
            }
        }
    }
}