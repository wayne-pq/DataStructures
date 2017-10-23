package JDK.genericity;

/**
 * @param <T>
 */
public class Array<T> {

    private T[] t;

    /**
     * 如果在构造器内部创建数组，因为是Object数组，而且因为泛型擦除，实际的T就是Object所以变量t还是Object数组
     */
    public Array() {
        this.t = (T[]) new Object[1];
    }

    public T get(int index) {
        return t[index];
    }

    /**
     * Object数组如果外面是String[]来接，运行时肯定会报cast异常。
     *
     * @return
     */
    public T[] getAll() {
        return t;
    }
}
