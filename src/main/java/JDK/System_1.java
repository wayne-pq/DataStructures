package JDK;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by panqian on 2017/3/14.
 */
public class System_1 {
    public static void main(String[] args) {
        //查找系统和工程所有参数
//        System.getProperties().list(System.out);

        //拿五个随机数
        Random random = new Random();
        IntStream ints = random.ints(5);
        System.out.println(Arrays.toString(ints.toArray()));

    }
}
