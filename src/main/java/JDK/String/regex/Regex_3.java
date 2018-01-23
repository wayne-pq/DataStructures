package JDK.String.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数量词
 * Created by panqian on 2017/1/19.
 */
public class Regex_3 {

    public static void main(String[] args) {

        Pattern compile = Pattern.compile("(abc)?+");
        Matcher matcher = compile.matcher("abcabcabcabc");

        System.out.println("是否匹配:" + matcher.find());
        System.out.println("匹配结果:" + matcher.group());
    }
}
