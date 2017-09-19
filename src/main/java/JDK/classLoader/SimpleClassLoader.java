package JDK.classLoader;


import java.io.IOException;
import java.io.InputStream;

public class SimpleClassLoader extends ClassLoader {

    //加载class类的入口靠的是这个方法，在双亲委派模型中，如果父加载器的findClass方法找不到类时，最后就会执行本方法。
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//      bootstrap ext app 三个类加载器都找不到，最后还要我自己来找，那我也找不到，我就随意直接返回Test类吧
        InputStream map = Test.class.getResourceAsStream("Test.class");
        try {
            byte[] bytes = new byte[map.available()];
            map.read(bytes);
            return super.defineClass(Test.class.getName(), bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //    如果你的classloader不想破坏双亲委派模型，就不要自己复写
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }
}
