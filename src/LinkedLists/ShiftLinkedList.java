package LinkedLists;

public class ShiftLinkedList {
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        LinkedList first = head;
        int count = 1;
        while (first.next != null){
            first = first.next;
            count++;
        }

        int offset = Math.abs(k)%count;
        if (offset == 0) return head;
        LinkedList current = head;
        if (k > 0){
            for (int i = 1; i < (count - offset); i++) {
                current = current.next;
            }
        }
        else {
            for (int i = 1; i < offset; i++) {
                current = current.next;
            }
        }
        LinkedList newHead = current.next;
        current.next = null;
        first.next = head;
        return newHead;
    }


    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
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


    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);

        LinkedList result = shiftLinkedList(head, 2);
        System.out.println(toString(result));
    }
}
