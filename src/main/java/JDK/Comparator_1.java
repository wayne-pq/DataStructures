package JDK;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays.sort排序时
 * comparing相同的，可以用thenComparing进行二级排序。
 * Created by panqian on 2017/3/9.
 */
public class Comparator_1 {
    public static void main(String[] args) {
        Student s1 = new Student("panqian01", 18, 100);
        Student s2 = new Student("panqian02", 20, 60);
        Student s3 = new Student("panqian03", 18, 65);
        Student s4 = new Student("panqian04", 19, 70);

        Student[] students = {s1, s2, s3, s4};

        Arrays.sort(students, Comparator.comparing(
                Student::getAge, (a1, a2) -> {
                    if (a1 == a2) {
                        return 0;
                    }
                    return a1 > a2 ? 1 : -1;
                }
        ).thenComparing(
                Student::getScore, (a1, a2) -> {
                    if (a1 == a2) {
                        return 0;
                    }
                    return a1 > a2 ? -1 : 1;
                }));

        System.out.println(Arrays.toString(students));

    }
}
