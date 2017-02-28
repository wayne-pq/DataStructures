package JDK.StreamAndLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Optional的用法
 * Created by panqian on 2017/2/27.
 */
public class Optional_1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }


        ArrayList<Integer> results = new ArrayList<>();
        //findany 可以返回结果中的任意一条
        Optional<Integer> any = list.stream().filter((x) -> x > 97).findAny();

        Integer integer = any.get();
        System.out.println("get方法取结果：" + integer);

        //如果结果存在，则可以传入函数对这个结果进行处理
        any.ifPresent(x -> results.add(x));

        //如果返回没有值，则可以做一些处理
        any.orElseThrow(() -> new NullPointerException("如果any没有值，则抛出异常"));

//        any.orElseGet(()->{
//            return 1+1;
//        });
//
//        any.orElse(0);

        Optional<Integer> afterMap = any.map(x -> x + 100);
        System.out.println("处理后的结果: " + afterMap);

        System.out.println("results 的大小：" + results);


        Function<Object, Object> identity = Function.identity();
        System.out.println(identity);

    }
}
