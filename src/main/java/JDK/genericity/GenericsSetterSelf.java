package JDK.genericity;

/**
 * 泛型基类成了所有子类的模板
 * @param <T>
 */
public class GenericsSetterSelf<T extends GenericsSetterSelf<T>> {
    void set(T arg){
        System.out.println("GenericsSetter set(T)");
    }
}
