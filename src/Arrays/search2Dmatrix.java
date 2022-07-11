package Arrays;

import java.util.Arrays;

public class search2Dmatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[matrix.length-1].length -1;

        while (start < matrix.length && end >=0){
            if (matrix[start][end] < target) start++;
            else if (matrix[start][end] > target) end--;
            else return new int[]{start , end};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] matrix = new int [][] {{1, 4, 7, 12, 15, 1000}, {2, 5, 19, 31, 32, 1001}, {3, 8, 24, 33, 35, 1002}, {40, 41, 42, 44, 45, 1003}, {99, 100, 103, 106, 128, 1004}};
        System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 44)));
    }
}
