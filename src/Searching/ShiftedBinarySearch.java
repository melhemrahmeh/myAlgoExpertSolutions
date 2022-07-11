package Searching;

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
        return shiftedBinarySearchHelper(array , 0 , array.length-1 , target);
    }

    public static int shiftedBinarySearchHelper(int[] array, int left , int right, int target) {
        if (left > right){
            return -1;
        }
        else {
            int mid = (left+right)/2;
            if (array[mid] == target){
                return mid;
            }
            else {
                if (array[left] < array[mid]){
                    if (array[left] <= target && target < array[mid]){
                        return shiftedBinarySearchHelper(array , left , mid-1 , target);
                    }
                    else {
                        return shiftedBinarySearchHelper(array , mid+1 , right , target);
                    }
                }
                else {
                    if (array[mid] < target && target <= array[right]){
                        return shiftedBinarySearchHelper(array , mid+1 , right , target);
                    }
                    else {
                        return shiftedBinarySearchHelper(array , left ,mid-1, target);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,8,9,1,2,3};
        System.out.println(shiftedBinarySearch(array , 4));
    }
}
