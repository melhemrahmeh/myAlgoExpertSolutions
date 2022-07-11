package LinkedLists;

import java.util.*;

class FindLoop{
    public static LinkedList findLoop(LinkedList head) {
        LinkedList first = head.next;
        LinkedList second = head.next.next;
        while (first != second){
            first = first.next;
            second = second.next.next;
        }

        first = head;
        while (first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;

        while(current.next != null) {
            if (current.value == current.next.value){
                current = current.next.next;
            }
            else {
                current = current.next;
            }
        }

        return linkedList;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
