package Arrays;

import java.util.*;

public class FirstDuplicateValue {
    static int firstDuplicateValue(int[] array) {
        HashSet<Integer> values = new HashSet<>();
        for (int val : array) {
            if (values.contains(val)) return val;
            else values.add(val);
        }
        return -1;
    }

    public static void main(String[] args) {
        var input = new int[] {2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(input));
    }
}
