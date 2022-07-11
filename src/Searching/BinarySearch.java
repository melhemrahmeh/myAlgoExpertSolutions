package Searching;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array , target , 0 , array.length-1);
    }

    public static int binarySearch(int[] array , int target , int left , int right){
        if (left <= right){
            int mid = (left+right)/2;
            if (array[mid] == target){
                return mid;
            }
            else if (array[mid] < target){
                return binarySearch(array , target , mid+1 , right);
            }
            else {
                return binarySearch(array , target , left , mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }
}
