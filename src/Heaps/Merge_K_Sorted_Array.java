package Heaps;

import java.util.*;

public class Merge_K_Sorted_Array {
    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        List<Integer> result = new ArrayList<>();
        List<Item> smallestItems = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            smallestItems.add(new Item(arrays.get(i).get(0), 0 , i));
        }
        MinHeap heap = new MinHeap(smallestItems);
        while (!heap.heap.isEmpty()){
            Item itemToRemove = heap.remove();
            result.add(itemToRemove.number);
            if (arrays.get(itemToRemove.arrayIndex).size()-1 > itemToRemove.index){
                heap.insert(new Item(arrays.get(itemToRemove.arrayIndex).get(itemToRemove.index+1) , itemToRemove.index+1, itemToRemove.arrayIndex));
            }
        }
        return result ;
    }

    static class Item{
        int number;
        int index;
        int arrayIndex;

        Item(Integer number, int index, int arrayIndex){
            this.number = number;
            this.index = index;
            this.arrayIndex = arrayIndex;
        }
    }
    static class MinHeap {
        List<Item> heap = new ArrayList<>();

        public MinHeap(List<Item> array) {
            heap = buildHeap(array);
        }

        public List<Item> buildHeap(List<Item> array) {
            int firstParentIndex = (array.size() - 2) / 2;
            for (int i = firstParentIndex; i >= 0; i--) {
                siftDown(i, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Item> heap) {
            int childOneIndex = currentIdx * 2 + 1;
            while (childOneIndex <= endIdx) {
                int childTwoIndex = currentIdx * 2 + 2;
                if (childTwoIndex > endIdx) childTwoIndex = -1;
                int indexToSwap;
                if (childTwoIndex != -1 && heap.get(childTwoIndex).number < heap.get(childOneIndex).number) {
                    indexToSwap = childTwoIndex;
                } else {
                    indexToSwap = childOneIndex;
                }
                if (heap.get(indexToSwap).number < heap.get(currentIdx).number) {
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    childOneIndex = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Item> heap) {
            int parentIndex = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx).number < heap.get(parentIndex).number) {
                swap(currentIdx, parentIndex, heap);
                currentIdx = parentIndex;
                parentIndex = (currentIdx - 1) / 2;
            }
        }

        public Item peek() {
            return heap.get(0);
        }

        public Item remove() {
            swap(0, heap.size() - 1, heap);
            Item valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        public void insert(Item value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Item> array) {
            Item temp = array.get(j);
            array.set(j, array.get(i));
            array.set(i, temp);
        }
    }
    public static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item item1, Item item2) {
            return Integer.compare(item1.number , item2.number);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        arrays.add(Arrays.asList(1, 5, 9, 21));
        arrays.add(Arrays.asList(-1, 0));
        arrays.add(Arrays.asList(-124, 81, 121));
        arrays.add(Arrays.asList(3, 6, 12, 20, 150));
        var actual = mergeSortedArrays(arrays);
        System.out.println(actual);

        ItemComparator comparator = new ItemComparator();
        PriorityQueue<Item> heap = new PriorityQueue<>(comparator);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            heap.add(new Item(arrays.get(i).get(0), 0 , i));
        }
        while (!heap.isEmpty()){
            Item itemToRemove = heap.remove();
            result.add(itemToRemove.number);
            if (arrays.get(itemToRemove.arrayIndex).size()-1 > itemToRemove.index){
                heap.add(new Item(arrays.get(itemToRemove.arrayIndex).get(itemToRemove.index+1) , itemToRemove.index+1, itemToRemove.arrayIndex));
            }
        }
        //return result ;
}
 }
