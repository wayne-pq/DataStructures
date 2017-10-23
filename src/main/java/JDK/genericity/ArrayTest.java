package JDK.genericity;

public class ArrayTest {
    public static void main(String[] args) {
        Array<String> stringArray = new Array<String>();
        String s = stringArray.get(0);
        String[] all = stringArray.getAll();
        System.out.println(s);
    }
}
