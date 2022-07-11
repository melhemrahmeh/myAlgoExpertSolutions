package Dynamic_Programming;

import java.util.*;

public class LIS {
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences , Integer.MIN_VALUE);

        int[] lengths = new int[array.length];
        Arrays.fill(lengths , 1);

        int maxLengthIndex = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lengths[j]+1 >= lengths[i]){
                    lengths[i] = lengths[j]+1;
                    sequences[i] = j;
                }
            }
            if (lengths[i] >= lengths[maxLengthIndex]){
                maxLengthIndex = i;
            }
        }

        List<Integer> sequenceBuild = new ArrayList<>();
        while (maxLengthIndex!= Integer.MIN_VALUE){
            sequenceBuild.add(0 , array[maxLengthIndex]);
            maxLengthIndex = sequences[maxLengthIndex];
        }
        return sequenceBuild;
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[] {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35}));
    }
}
