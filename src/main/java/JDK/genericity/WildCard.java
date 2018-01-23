package JDK.genericity;

import java.util.*;

/**
 * 通配符
 */
public class WildCard {

    public static void main(String[] args) {

//        Collection[] collections = new ArrayList[]{};
//        ArrayList<Collection> collections1 = new ArrayList<ArrayList>();

        ArrayList<Collection> hashSets1 = new ArrayList<>();
        hashSets1.add(new HashSet());


        ArrayList<HashSet> hashSets = new ArrayList<>();
        hashSets.add(new HashSet());

//        因为 ? extends Set 代表接受泛型参数是 Set 和 Set的子类 的ArrayList容器  所以这个赋值是合法的
        ArrayList<? extends Set> sets = hashSets;

//        因为 ? extends Set 编译器不知道sets引用指向什么对象，有可能是 HashSet，可能是TreeSet，这种不确定性导致sets不能使用add方法。
//        sets.add(new HashSet());
        sets.add(null);

//        因为这个泛型参数的上限是Set 所以只返回set类型
        Set set = sets.get(0);

//        因为 ? super List 代表接受泛型参数是 List 和 List的父类 的ArrayList容器  所以这个赋值是合法的
        ArrayList<Collection> collections = new ArrayList<>();
        ArrayList<? super List> list = collections;

//        对于 add方法，只能放List或List的子类，因为list容器泛型参数都是List的父类 不会出现问题
        list.add(new ArrayList());
//        list.add(new HashSet());
//        list.add(new Object());

        //    因为这个泛型参数的下限是List    所以无法确定这是个什么类型，只能返回Object
        Object object = list.get(0);


//        说明泛型是可以接受子类的，泛型参数类型的子类
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());

        ArrayList<Collection> collections2 = new ArrayList<>();
//        collections2.add(new ArrayList());
        ArrayList<?> objects = new ArrayList<>();
//        ?代表持有某种特定类型 ，所以也可以是Collection，这种赋值时合法的
        objects = collections2;
        objects.add(null);
//        objects.add(1);
        //?代表持有某种特定类型，d但是不确定具体哪种，所以只能返回Object
        Object o = objects.get(0);
//?代表持有某种特定类型，但是什么类型编译器并不知道，所以为了安全起见，不会让你用add方法
//                objects.add(new Object());

//        Object o = objects.get(0);
//List list1=new ArrayList();
//List list2=(ArrayList)new ArrayList<>();
//        f(objects);
//        f(new ArrayList<>());
//        f(collections2);
//        ArrayList<?> integers = new ArrayList<Integer>();

    }

    public static <T> void f(ArrayList<? super T> arrayList) {
    }
}
