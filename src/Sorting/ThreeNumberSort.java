package Sorting;

import java.util.Arrays;

public class ThreeNumberSort {
    public static int[] threeNumberSort(int[] array, int[] order) {
        int[] count = {0,0,0};
        for (int k : array) {
            if (k == order[0]) count[0]++;
            if (k == order[1]) count[1]++;
            if (k == order[2]) count[2]++;
        }
        int[] newArr = new int[array.length];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                newArr[index++] = order[i];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        var array = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        var order = new int[] {0, 1, -1};
        var expected = new int[] {0, 0, 0, 1, 1, 1, -1, -1};
        var actual = threeNumberSort(array, order);
        System.out.println(Arrays.toString(actual));
    }
}
