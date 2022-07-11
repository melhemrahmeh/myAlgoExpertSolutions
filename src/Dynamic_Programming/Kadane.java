package Dynamic_Programming;

public class Kadane {
    public static int kadanesAlgorithm(int[] array) {
        int currentSum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            currentSum = Math.max(array[i] , currentSum + array[i]);
            max = Math.max(max , currentSum);
        }
        return max;
    }

    public static void main(String[] args) {
        /*int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(input));
*/
        System.out.println(kadanesAlgorithm(new int[]{1,2,-1,3,4,1}));
    }
}
