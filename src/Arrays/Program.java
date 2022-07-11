package Arrays;

import java.util.Arrays;

public class Program {  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    int[][] cloned = intervals.clone();
    Arrays.sort(cloned , (a,b)-> Integer.compare(a[0], b[0]));
    return new int[][] {};
}
}
