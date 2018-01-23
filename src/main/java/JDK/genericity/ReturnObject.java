package JDK.genericity;

/**
 * @param <A>
 * @param <B>
 * @author panqian
 */
public class ReturnObject<A, B> {

    public final A a;
    public final B b;

    public ReturnObject(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public <A> A t(A a) {
        return a;
    }

    @Override
    public String toString() {
        return "ReturnObject{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
