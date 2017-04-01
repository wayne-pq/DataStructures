package JDK.Static;

/**
 * Created by panqian on 2017/3/17.
 */
public class Static_1 {

    //非静态变量的初始化会第二执行
    Window w = new Window(1);

    //Static_1初始化时，静态变量会先执行
    static Door r = new Door(1);

    //构造器会最后执行
    public Static_1(int i) {
        System.out.println("Static_1(" + i + ")");
    }
}
