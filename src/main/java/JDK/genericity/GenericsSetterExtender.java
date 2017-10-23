package JDK.genericity;

public class GenericsSetterExtender extends GenericsSetter<String> {
    public static void main(String[] args) {
        GenericsSetterExtender genericsSetterExtender = new GenericsSetterExtender();
        genericsSetterExtender.set("sss");
        genericsSetterExtender.set(1);
    }

    void set(Integer arg) {
        System.out.println("GenericsSetter set(Integer)");
    }
}
