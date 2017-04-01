package JDK;

import java.util.Arrays;

/**
 * Created by panqian on 2017/2/17.
 */
public class Math_1 {

    public static void main(String[] args) {

        int n = 100;
        int[] maths = new int[n];
        int[] result = new int[6];


        for (int i = 0; i < n; i++) {
            maths[i] = i + 1;
        }

        for (int i = 0; i < 6; i++) {
            //Math.random() 取值范围 [0,1) , 乘n的话  取值就是  [0,n)
            int random = (int) (Math.random() * n + 1);

            result[i] = maths[random];

            maths[random] = maths[n - 1];
            n--;
        }

        Arrays.sort(result);

        System.out.println(Arrays.toString(result));
    }
}
