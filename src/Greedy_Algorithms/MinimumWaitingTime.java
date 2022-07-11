package Greedy_Algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumWaitingTime {
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int minimumWaitingTime = 0;
        int[] array = new int[queries.length-1];
        Arrays.fill(array , 0);
        for (int i = 0; i < queries.length-1; i++) {
            minimumWaitingTime+=queries[i];
            array[i] = minimumWaitingTime;
            System.out.println(Arrays.toString(array));
        }
        return IntStream.of(array).sum();
    }

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        var actual = minimumWaitingTime(queries);
        System.out.println(actual);
        System.out.println(actual == expected);

    }
}
