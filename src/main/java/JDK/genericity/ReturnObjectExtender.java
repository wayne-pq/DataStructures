package JDK.genericity;

/**
 * @param <A>
 * @param <B>
 * @author panqian
 */
public class ReturnObjectExtender<A, B, C> extends ReturnObject<A, B> {

    public final C c;

    public ReturnObjectExtender(A a, B b, C c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public String toString() {
        return "ReturnObjectExtender{" +
                "c=" + c +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
