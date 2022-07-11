package Arrays;

import java.util.*;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(targetSum - array[i])){
                return new int[]{ targetSum-array[i] , array[i]};
            }
            map.put(array[i] , i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] output = twoNumberSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output));
    }
}
