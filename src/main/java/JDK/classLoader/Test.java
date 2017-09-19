package JDK.classLoader;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("JDK.classLoader.Test");
        System.out.println(aClass);
    }
}
