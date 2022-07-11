package Searching;

public class QuickSelect {
    public static int quickselect(int[] array , int k){
        int position = k-1;
        return quickSelectHelper(array , 0 , array.length -1, position);
    }
    public static int quickSelectHelper(int[] array , int start , int end, int position){
        while (true){
            if (start > end){
                throw new RuntimeException("Your Algorithm should never arrive here");
            }
            else {
                int pivot = start;
                int left = start+1;
                int right = end;
                while (left <= right){
                    if (array[left] > array[pivot] && array[right] < array[pivot]) {
                        swap(left , right , array);
                    }
                    if (array[left] <= array[pivot]){
                        left++;
                    }
                    if (array[right] >= array[pivot]){
                        right--;
                    }
                }
                swap(pivot , right , array);
                if (right == position){
                    return array[right];
                }
                else if (right < position){
                    start = right+1;
                }
                else {
                    end = right-1;
                }
            }
        }
    }
    public static void swap(int left , int right , int[] array){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
