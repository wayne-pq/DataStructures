package JDK.StreamAndLambda;

import java.util.stream.IntStream;

/**
 * 原始类型流
 * Created by panqian on 2017/3/1.
 */
public class IntStream_1 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        IntStream afterMap = intStream.map(x -> x + 1);
        int[] ints = afterMap.toArray();

        for (int i : ints) {
            System.out.println(i + " ");
        }
    }
}
