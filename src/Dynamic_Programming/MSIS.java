package Dynamic_Programming;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
public class MSIS {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.
        int[] sequences = new int[array.length];
        Arrays.fill(sequences , Integer.MIN_VALUE);

        int[] sums = array.clone();
        int maxSum = 0;
        int maxSumIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]){
                    sums[i] = Math.max(sums[i] , sums[j]+array[i]);
                    sequences[i] = j;
                }
            }
            if (sums[i] >= maxSum){
                maxSum = sums[i];
                maxSumIndex = i;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        result.get(0).add(maxSum);
        while (maxSumIndex != Integer.MIN_VALUE){
            result.get(1).add(0 , array[maxSumIndex]);
            maxSumIndex = sequences[maxSumIndex];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {10, 70, 20, 30, 50, 11, 30};
        //int[][] expected = {{110}, {10, 20, 30, 50}};
        System.out.println(maxSumIncreasingSubsequence(input));

    }
}
