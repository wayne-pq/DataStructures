package JDK.StreamAndLambda.groupToMap;

/**
 * Created by panqian on 2017/2/28.
 */
public class Group {
    String classes;
    String num;
    String name;

    public Group() {
    }

    public Group(String classes, String num, String name) {
        this.classes = classes;
        this.num = num;
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
