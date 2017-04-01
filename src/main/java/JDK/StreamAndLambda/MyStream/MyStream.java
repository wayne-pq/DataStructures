package JDK.StreamAndLambda.MyStream;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * Created by panqian on 2017/3/2.
 */
public class MyStream {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        int num = 0;

        reentrantLock.lock();
        try {
            for (int i = 0; i < 100; i++) {
                num++;
            }
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }

        System.out.println("普通方式:" + num);


        //lambda编程
        MyStream.reentrantLock((j) -> {
            for (int i = 0; i < 100; i++) {
                j++;
            }
            System.out.println("lambda编程:" + j);
        });

    }

    public static void reentrantLock(Consumer<Integer> c) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
            int num = 0;
            c.accept(num);
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }
}
