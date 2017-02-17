package ENUM;

import java.util.EnumSet;

/**
 * 枚举的用法
 * Created by panqian on 2017/2/13.
 */
public class ENUM_1 {

    enum WEEKEND {MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};

    public static void main(String[] args) {
        //使用枚举
        System.out.println(WEEKEND.MONDAY.toString());

        //Enum.valueOf使用方法
        WEEKEND day = Enum.valueOf(WEEKEND.class, "TUESDAY");
        System.out.println(day);

        EnumSet<WEEKEND> weekends = EnumSet.allOf(WEEKEND.class);
        System.out.println(weekends.toString());
        EnumSet<WEEKEND> weekends1 = EnumSet.noneOf(WEEKEND.class);
        System.out.println(weekends1.toString());

    }
}
