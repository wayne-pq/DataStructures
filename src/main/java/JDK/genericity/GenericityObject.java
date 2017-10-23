package JDK.genericity;

import java.util.AbstractList;
import java.util.List;

/**
 * @param <A>
 * @param <B>
 * @author panqian
 */
public class GenericityObject {


    public static List t(AbstractList a) {
        return a;
    }
}
