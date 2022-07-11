package Arrays;

import java.util.*;

public class FourNumberSum {
    static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
         Arrays.sort(array);

            List<Integer[]> allQuadruple = new ArrayList<>();

            for (int i = 0; i < array.length - 3; i++) {
                for (int j = i + 1; j < array.length - 2; j++) {

                    int sum = targetSum - (array[i] + array[j]);

                    int start = j + 1;
                    int end = array.length - 1;

                    while (start < end) {
                        int t = array[start] + array[end];
                        if (t == sum) {
                            allQuadruple.add(new Integer[]{array[start], array[end], array[i], array[j]});
                            start++;
                            end--;
                        } else if (t < sum) {
                            start++;
                        } else {
                            end--;
                        }
                    }
                }
            }

            return allQuadruple;
        }


    public static void main(String[] args) {
        List<Integer[]> output = fourNumberSum(new int[] {7, 6, 4, -1, 1, 2}, 16);
        System.out.println(output);
    }
}
