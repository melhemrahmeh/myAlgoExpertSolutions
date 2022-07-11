package Arrays;

import java.util.*;

public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result =  new ArrayList<>();
        for (int i = 0; i < array.length-2; i++) {
            int left =i+1;
            int right = array.length-1;
            while (left < right){
                int temp = array[i] + array[left] + array[right];
                if (temp == targetSum){
                    result.add(new Integer[]{array[i] , array[left] , array[right]});
                    left++;
                    right--;
                }
                else if (temp > targetSum) {
                    right--;
                }
                else if (temp < targetSum){
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer[]> output = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        System.out.println(output);
    }
}
