package JDK.genericity;


/**
 * 边界
 *
 * @author panqian
 */
public class WildCard2<T extends String> {

    public static void main(String[] args) {
        WildCard2<String> stringWildCardTest = new WildCard2<>();
        stringWildCardTest.f("");
    }

    public void f(T t) {
        t.isEmpty();
    }
}
