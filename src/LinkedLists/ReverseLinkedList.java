package LinkedLists;

public class ReverseLinkedList {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static String toString(LinkedList head){
        LinkedList first = head;
        String list = "";
        while (first != null){
            list += first.value + ", ";
            first = first.next;
        }
        return list.substring(0 , list.length()-2);
    }
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previous = null;
        LinkedList current = head;
        while (current!=null){
            LinkedList next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    public static void main(String[] args) {
        var head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);
        System.out.println(toString(head));
        System.out.println(toString(reverseLinkedList(head)));
    }
}
