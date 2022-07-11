package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
        if(array[0] == 0) return false;
        int i = 0;
        ArrayList<Integer> visited = new ArrayList<>();
        for (int j = 0; j < array.length; j++) {
            visited.add(0);
        }
        for (int j = 0; j < array.length; j++) {
            if(Math.abs(array[j]) > array.length){
                if (array[j] < 0){
                    array[j] = -(-array[j] % array.length);
                }
                else {
                    array[j] = array[j] % array.length;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        int numOfElementVisited = 0;
        while (visited.contains(0)){
            if ((array[i] + i ) < array.length){
                i+= array[i];
                visited.set(i , visited.get(i)+1);
            }
            if ((array[i] + i) < 0) {
                i = (array.length) + (array[i] + i);
                visited.set(i , visited.get(i)+1);
            }
            if ((array[i]+ i) > array.length){
                i = i + array[i] - (array.length);
                visited.set(i , visited.get(i)+1);
            }
            numOfElementVisited++;
            if (numOfElementVisited == array.length) break;
            if (i == 0){
                break;
            }
        }
        int sum = 0 ;
        for (int j = 0; j < visited.size(); j++) {
            sum+=visited.get(i);
        }
        return  (sum == visited.size());
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(arr));
        System.out.println(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}));
    }
}
