package Heaps;

import java.util.*;
import java.util.function.BiFunction;

public class ContinuousMedian {
    static class ContinuousMedianHandler {
        Heap lowers = new Heap(Heap::MAX_HEAP_COMPARATOR , new ArrayList<>());
        Heap greaters = new Heap(Heap::MIN_HEAP_COMPARATOR , new ArrayList<>());
        double median = 0;

        public void insert(int number) {
            if (lowers.heap.isEmpty() || number < lowers.peek()) lowers.insert(number);
            else greaters.insert(number);
            reBalance();
            updateMedian();
        }

        public void reBalance(){
            if (lowers.heap.size() - greaters.heap.size() == 2) greaters.insert(lowers.remove());
            if (greaters.heap.size() - lowers.heap.size() == 2) lowers.insert(greaters.remove());
        }
        public void updateMedian(){
            if (lowers.heap.size() == greaters.heap.size()) median = ((double) lowers.peek() + (double) greaters.peek()) /2 ;
            else if ( lowers.heap.size() > greaters.heap.size()) median = lowers.peek();
            else median = greaters.peek();
        }
        public double getMedian() {
            return median;
        }
    }


    static class Heap{
        List<Integer> heap = new ArrayList<Integer>();
        BiFunction<Integer, Integer ,Boolean> comparaisonFunction;

        public Heap(BiFunction<Integer, Integer ,Boolean> comparaisonFunc , List<Integer> array) {
            heap = buildHeap(array);
            comparaisonFunction = comparaisonFunc;
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
                if (childTwoIndex != -1 && comparaisonFunction.apply(heap.get(childTwoIndex) , heap.get(childOneIndex))) {
                    indexToSwap = childTwoIndex;
                } else {
                    indexToSwap = childOneIndex;
                }
                if (comparaisonFunction.apply(heap.get(indexToSwap) , heap.get(currentIdx))) {
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
            while (currentIdx > 0 && comparaisonFunction.apply(heap.get(currentIdx) , heap.get(parentIndex))) {
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

        public static boolean MAX_HEAP_COMPARATOR(Integer a , Integer b){
            return a > b;
        }

        public static boolean MIN_HEAP_COMPARATOR(Integer a , Integer b){
            return a < b;
        }

    }
    public static void main(String[] args) {
        /*ContinuousMedianHandler handler = new ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        System.out.println(handler.getMedian());
        handler.insert(100);
        System.out.println(handler.getMedian());*/

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(4);
        integers.add(1);
        integers.add(6);
        System.out.println(integers.peek());

        integers.remove(1);
        System.out.println(integers.peek());

    }
}
