package Sorting;

import java.util.*;

public class HeapSort {
    public static int[] heapSort(int[] array) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arr.add(array[i]);
        }
        buildHeap(arr);
        for (int i = arr.size()-1; i >0 ; i--) {
            swap(0 , i , arr);
            siftDown(0 , i-1 , arr);
        }
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
      return result;
    }

    public static List<Integer> buildHeap(List<Integer> array) {
        int firstParentIndex = (array.size() - 2) / 2;
        for (int i = firstParentIndex; i >= 0; i--) {
            siftDown(i, array.size() - 1, array);
        }
        return array;
    }

    public static void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int childOneIndex = currentIdx * 2 + 1;
        while (childOneIndex <= endIdx) {
            int childTwoIndex = currentIdx * 2 + 2;
            if (childTwoIndex > endIdx) childTwoIndex = -1;
            int indexToSwap;
            if (childTwoIndex != -1 && heap.get(childTwoIndex) > heap.get(childOneIndex)) {
                indexToSwap = childTwoIndex;
            } else {
                indexToSwap = childOneIndex;
            }
            if (heap.get(indexToSwap) > heap.get(currentIdx)) {
                swap(currentIdx, indexToSwap, heap);
                currentIdx = indexToSwap;
                childOneIndex = currentIdx * 2 + 1;
            } else {
                return;
            }
        }
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    public static void main(String[] args) {
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int j : input) {
            heap.add(j);
        }
        int[] list = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            list[i] = heap.remove();
        }
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(heapSort(input)));
    }
}
