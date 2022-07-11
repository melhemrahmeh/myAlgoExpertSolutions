package Arrays;
import java.util.*;

public class MergeOverlappingIntervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals , (a , b ) -> Integer.compare(a[0] , b[0]));

        int[] current = sortedIntervals[0];
        list.add(current);

        for (int[] interval: sortedIntervals) {
            if (current[1] >= interval[0]){
                current[1] = Math.max(current[1] , interval[1]);
            }
            else {
                current = interval;
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }


    public static void main(String[] args) {
        int[][] intervals =
                new int[][] {
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        int[][] expected =
                new int[][] {
                        {1, 2},
                        {3, 8},
                        {9, 10}
                };
        int[][] actual = mergeOverlappingIntervals(intervals);
        System.out.println(Arrays.deepToString(actual));
        System.out.println(Arrays.deepToString(expected));
    }
}
