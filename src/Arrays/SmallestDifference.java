package Arrays;

import java.util.Arrays;

public class SmallestDifference {
    static class Element {
        int value;
        int arrayIndex;
        Element(int value , int arrayIndex){
            this.value = value;
            this.arrayIndex = arrayIndex;
        }
    }
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
       Arrays.sort(arrayOne);
       Arrays.sort(arrayTwo);
        Element[] merged = new Element[arrayOne.length + arrayTwo.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arrayOne.length && j < arrayTwo.length){
            if (arrayOne[i] < arrayTwo[j]){
                merged[k++] = new Element(arrayOne[i++] ,1);
            }
            else {
                merged[k++] = new Element(arrayTwo[j++] , 2);
            }
        }
        while (i < arrayOne.length)
            merged[k++] = new Element(arrayOne[i++] , 1);
        while (j < arrayTwo.length)
            merged[k++] = new Element(arrayTwo[j++] , 2);
        System.out.println(Arrays.toString(merged));

        int first = 0;
        int second = 1;

        int smallest = Integer.MAX_VALUE;
        while (first < merged.length){
            if (merged[second].value - merged[first].value < smallest && merged[second].arrayIndex != merged[first].arrayIndex){


            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] expected = {28, 26};
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})));
    }
}
