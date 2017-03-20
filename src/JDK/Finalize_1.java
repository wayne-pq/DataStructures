package JDK;

/**
 * finalize运行并不代表垃圾回收，
 * Created by panqian on 2017/3/16.
 */
public class Finalize_1 {
    boolean judege;

    public Finalize_1(boolean judege) {
        this.judege = judege;
    }

    public void toFalse() {
        judege = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Finalize_1 a = new Finalize_1(true);
        //这个对象没有对象引用，System.gc()运行后会强制回收
        new Finalize_1(true);

        a.toFalse();

        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        if(judege)
            System.out.println("Error : judege is true");
        super.finalize();
    }
}
