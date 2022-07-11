package Searching;

import java.util.Arrays;

public class FindLargestThree {
    public static int[] findThreeLargestNumbers(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > first){
                third = second;
                second = first;
                first = array[i];
            }
            else if (array[i] > second){
                third = second;
                second = array[i];
            }
            else if (array[i] > third){
                third = array[i];
            }
        }
        return new int[]{third,second,first};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
    }
}
