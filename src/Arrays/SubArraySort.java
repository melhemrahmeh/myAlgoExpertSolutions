package Arrays;

import java.util.*;

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        int[] sorted = array.clone();
        Arrays.sort(sorted);

        if (array.length == 2 && array[0] > array[1]) return new int[]{0,1};
        if (array.length < 3 || Arrays.equals(array, sorted)) return  new int[]{-1,-1};

        int start = sorted.length;
        int end = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != array[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return new int[]{start , end};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }
}
