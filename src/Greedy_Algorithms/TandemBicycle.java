package Greedy_Algorithms;

import java.util.Arrays;

public class TandemBicycle {
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (fastest){
            int max = 0;
            for (int i = 0; i < redShirtSpeeds.length; i++) {
                max+=Math.max(redShirtSpeeds[i], blueShirtSpeeds[redShirtSpeeds.length - i - 1]);
            }
            return max;
        }
        else {
            int min = 0;
            for (int i = 0; i < redShirtSpeeds.length; i++) {
                min+=Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        var actual = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        System.out.println(actual);
        System.out.println(expected == actual);

    }
}
