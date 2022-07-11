package Dynamic_Programming;

public class MaxSubsetSumNoAdjacent {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        int[] dp = array.clone();
        if (array.length == 1){
            return array[0];
        }
        else if (array.length == 0){
            return 0;
        }
        dp[1] = Math.max(array[0] , array[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1] ,dp[i-2]+array[i]);
        }
        return dp[array.length-1];
    }

    public static void main(String[] args) {

    }
}
