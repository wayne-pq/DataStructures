package JDK.genericity;

public class Exception {


    public static void main(String[] args) {
        Exception exception = new Exception();
        exception.new Obj<RuntimeException>() {
            @Override
            public void g() throws RuntimeException {
                throw new RuntimeException();
            }
        };
    }

    abstract class Obj<E extends java.lang.Exception> {
        public abstract void g() throws E;
    }

}
