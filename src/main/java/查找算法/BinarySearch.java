package 查找算法;

import java.text.Collator;

public class BinarySearch {
    public static void main(String[] args) {
        String[] str = {"b", "c", "d", "e", "f"};

        System.out.println(BinarySearch.binarySearch(str, "a"));
        System.out.println(BinarySearch.binarySearch(str, "g"));
        System.out.println(BinarySearch.binarySearch(str, "b"));
        System.out.println(BinarySearch.binarySearch(str, "c"));
        System.out.println(BinarySearch.binarySearch(str, "f"));
    }

    public static int binarySearch(String[] strs, String num) {

        Collator instance = Collator.getInstance();

        if (strs.length == 0)
            return -1;

        int low = 0;
        int high = strs.length - 1;

        int mid;

        while (low <= high) {
            mid = (high + low) / 2;
            int compare = instance.compare(num, strs[mid]);
            if (compare > 0) {
                low = mid + 1;
            } else if (compare < 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
