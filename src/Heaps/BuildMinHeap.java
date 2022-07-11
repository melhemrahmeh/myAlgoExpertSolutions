package Heaps;

import java.util.*;

public class BuildMinHeap {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIndex = (array.size() - 2) / 2;
            for (int i = firstParentIndex; i >= 0; i--) {
                siftDown(i, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIndex = currentIdx * 2 + 1;
            while (childOneIndex <= endIdx) {
                int childTwoIndex = currentIdx * 2 + 2;
                if (childTwoIndex > endIdx) childTwoIndex = -1;
                int indexToSwap;
                if (childTwoIndex != -1 && heap.get(childTwoIndex) < heap.get(childOneIndex)) {
                    indexToSwap = childTwoIndex;
                } else {
                    indexToSwap = childOneIndex;
                }
                if (heap.get(indexToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    childOneIndex = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIndex = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIndex)) {
                swap(currentIdx, parentIndex, heap);
                currentIdx = parentIndex;
                parentIndex = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Integer> array) {
            int temp = array.get(j);
            array.set(j, array.get(i));
            array.set(i, temp);
        }
    }

    public static void main(String[] args) {
        /* MinHeap heap = new MinHeap(new ArrayList<Integer>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        System.out.println(heap.heap);
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        heap.add(6);
        heap.add(4);
        heap.add(-1);

        System.out.println(heap);
    }
}
