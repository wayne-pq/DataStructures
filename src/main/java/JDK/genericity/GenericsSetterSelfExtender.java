package JDK.genericity;

public class GenericsSetterSelfExtender extends GenericsSetterSelf<GenericsSetterSelfExtender> {

    public static void main(String[] args) {
        GenericsSetterSelfExtender genericsSetterExtender = new GenericsSetterSelfExtender();
//        利用协变只能调用子类的方法
//        genericsSetterExtender.set(new GenericsSetterSelf());
//        利用协变能调用子类的方法
        genericsSetterExtender.set(new GenericsSetterSelfExtender());
    }
}
