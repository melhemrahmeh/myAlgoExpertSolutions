package Arrays;

import java.util.*;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> result = new ArrayList<>();
        int startRow = 0;
        int startColumn = 0;
        int endRow = array.length-1;
        int endColumn = array[0].length-1;

        while (startRow <= endRow && startColumn <= endColumn){
            for (int i = startColumn; i <= endColumn; i++) {
                result.add(array[startRow][i]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(array[i][endColumn]);
            }
            for (int i = endColumn-1; i <= startColumn; i--) {
                result.add(array[endRow][i]);
            }
            for (int i = endRow-1; i <= startRow+1; i--) {
                result.add(array[i][startColumn]);
            }
            startRow++;
            startColumn++;
            endColumn--;
            endRow--;
        }
        return result;
    }

    public static void main(String[] args) {
        var input =
                new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var actual = spiralTraverse(input);
        System.out.println(actual);
        System.out.println(expected.equals(actual));

    }
}
