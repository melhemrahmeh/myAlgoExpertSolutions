package Arrays;

import java.util.*;

public class MoveToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int start = 0;
        int end = array.size() -1;
        while (start < end){
            while (start < end && array.get(start) == toMove){
                end--;
                int temp = array.get(start);
                array.set(start , array.get(end));
                array.set(end , temp);
            }
            start++;
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        System.out.println(moveElementToEnd(array , toMove));
    }
}
