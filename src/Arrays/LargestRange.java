package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        int[] largestRange = new int[2];
        int largestResult = 0;

        Map<Integer , Boolean> nums = new HashMap<>();

        for (int num : array){
            nums.put(num , true);
        }

        for(int num : array){
            if (!nums.get(num)) continue;
            nums.put(num , false);

            int currentLength = 1;
            int left = num-1;
            int right = num+1;

            while (nums.containsKey(left)){
                nums.put(left , false);
                currentLength++;
                left--;
            }
            while (nums.containsKey(right)){
                nums.put(right , false);
                currentLength++;
                right++;
            }
            if (currentLength > largestResult){
                largestResult = currentLength;
                largestRange = new int[]{left+1, right-1};
            }
        }
        return largestRange;
    }

    public static void main(String[] args) {
        int[] expected = {0, 7};
        System.out.println(Arrays.toString(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6})));
    }
}
