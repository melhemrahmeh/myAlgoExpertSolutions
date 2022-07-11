package Dynamic_Programming;

import Heaps.Merge_K_Sorted_Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinNumberOfJump {
    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        return -1;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap =  new PriorityQueue<>();
        heap.add(3);
        heap.add(5);
        heap.add(-1);
        heap.add(-6);
        System.out.println(heap.peek());
        heap.poll();
        System.out.println(heap.peek());
    }
}
