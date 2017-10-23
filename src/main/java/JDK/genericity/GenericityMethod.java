package JDK.genericity;

public class GenericityMethod {

    public static <A> A t(A a) {
        return a;
    }

    public static String t1() {
        return t("");
    }

//    public  A t1(A a) {
//        return a;
//    }
}
