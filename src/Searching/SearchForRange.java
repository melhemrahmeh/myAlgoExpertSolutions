package Searching;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SearchForRange {
    public static int[] searchForRange(int[] array, int target) {
        int[] result = new int[2];
        result[0] = findStartingIndex(array , target);
        result[1] = findEndingIndex(array , target);
        return result;
    }

    public static int findStartingIndex(int[] array, int target) {
        int index = -1;

        int start = 0;
        int end = array.length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (array[mid] >= target) end = mid - 1;
            else start = mid+1;
            if (array[mid] == target) index = mid;
        }
        return index;
    }

    public static int findEndingIndex(int[] array, int target) {
        int index = -1;

        int start = 0;
        int end = array.length-1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if (array[mid] <= target) start = mid + 1;
            else end = mid-1;
            if (array[mid] == target) index = mid;
        }
        return index;
    }


    public static void main(String[] args) {
        int[] output = searchForRange(new int[] {0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73}, 45);
        System.out.println(Arrays.toString(output));
    }
}
