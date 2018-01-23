package JDK.genericity;

import java.util.ArrayList;

public class ReturnObjectTest {
    public static void main(String[] args) {
//        ReturnObject<String, String> returnObject = new ReturnObject("A", "B");
////        类型的显式声明
//        String t = returnObject.t("");
////        Object o = returnObject.<String>t1("");
//        System.out.println(returnObject);

        Class aClass = new ArrayList<Integer>().getClass();
        Class aClass1 = new ArrayList<>().getClass();

        System.out.println(aClass == aClass1);

    }
}
