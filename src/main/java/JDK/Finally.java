package JDK;

/**
 * 演示 Finally 无论怎样都会最后执行
 */
public class Finally {
    public static void main(String[] args) {
        int i = 1;
        int i1 = i(i);
        System.out.println(i1);
    }

    public static int i(int i) {
        try {
            return i;
        } catch (Exception e) {
        } finally {
            return ++i;
        }
    }

//    public static int j(){
//        System.out.println(2);
//        return 2;
//    }
//    public static int j1(){
//        System.out.println(3);
//        return 3;
//    }
//    public static int j2(){
//        System.out.println(4);
//        return 1;
//    }
}
