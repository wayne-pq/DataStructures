package JDK.String;

/**
 * Created by panqian on 2017/6/30.
 */
public class Intern {

    public static void main(String[] args) {
        String s0 = new String("1");
        String s1 = "1";
        String s2 = "1";

        String s3 = "12";
        String s4 = "2";

        String s5 = s0.intern();

        if (s1 == s2) {
            System.out.println("1内存地址相同");
        }

        if (s0.intern() == s1) {
            System.out.println("2内存地址相同");
        }

        if (s0.intern() == s0) {
            System.out.println("3内存地址相同");
        }

        if (s0 == s1) {
            System.out.println("4内存地址相同");
        }

        if (s3 == "1" + "2") {
            System.out.println("5内存地址相同");
        }

        if (s3 == s2 + s4) {
            System.out.println("6内存地址相同");
        }

        if (s3 == "1" + s4) {
            System.out.println("7内存地址相同");
        }

        if (s5 == s1) {
            System.out.println("8内存地址相同");
        }

        if (s0 == s1) {
            System.out.println("9内存地址相同");
        }
    }
}
