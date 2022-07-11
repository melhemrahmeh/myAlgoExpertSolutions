package Arrays;

public class LongestPeak {
    public static int longestPeak(int[] array) {
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            int count = 1;
            boolean foundDecreasing = false;

            int j = i;

            while (j < array.length && array[j] > array[j-1]){
                j++;
                count++;
            }
            while ( i!= j && j < array.length && array[j] < array[j-1]){
                j++;
                count++;
                foundDecreasing = true;
            }

            if (i!= j && foundDecreasing && count > 2){
                result = Math.max(result , count);
                j--;
            }
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(input));
    }
}
