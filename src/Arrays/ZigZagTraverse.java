package Arrays;

import java.util.*;

public class ZigZagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        List<Integer> result = new LinkedList<>();
        while (!(row < 0 || row > array.size()-1 || col < 0 || col > array.get(0).size()-1)){
            result.add(array.get(row).get(col));
            if (goingDown){
                if (col == 0 || row == array.size()-1){
                    goingDown = false;
                    if (row == array.size()-1){
                        col++;
                    }
                    else {
                        row++;
                    }
                }
                else {
                    row++;
                    col--;
                }
            }
            else {
                if (col == array.get(0).size()-1 || row == 0){
                    goingDown = true;
                    if (col == array.get(0).size()-1){
                        row++;
                    }
                    else {
                        col++;
                    }
                }
                else {
                    row--;
                    col++;
                }
            }
        }
        return result;
    }
}
