package JDK;

import java.util.Random;

/**
 * Created by panqian on 2017/2/17.
 */
public class Math_2 {

    public static void main(String[] args) {

        //余数应该不是负数
        System.out.println(-3%2);
        //做调整
        System.out.println(Math.floorMod(-3,2));


        //直接截取
        System.out.println("直接截取："+3/2);
        //四舍五入
        System.out.println("四舍五入："+Math.round(3/2));

        //nextInt(10) 生成[0,10)
        //nextInt() int 范围内
        Random random = new Random();
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt());

    }
}
