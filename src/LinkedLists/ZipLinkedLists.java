package LinkedLists;

public class ZipLinkedLists {
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

    public static LinkedList zipLinkedList(LinkedList linkedList) {
        if (linkedList == null || linkedList.next == null) return linkedList;
        LinkedList slow = linkedList;
        LinkedList fast = linkedList;
        LinkedList l1 = linkedList;
        LinkedList l2;

        LinkedList div = linkedList;
        while (fast!=null && fast.next !=null){
            div = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        div.next = null;
        l2 = reverse(slow);
        LinkedList result = l1;
        while (l1 !=null && l2!=null){
            LinkedList l1next = l1.next;
            LinkedList l2next = l2.next;
            l1.next = l2;

            if (l1next == null){
                break;
            }

            l2.next = l1next;

            l1 = l1next;
            l2 = l2next;
        }
        return result;
    }

    public static LinkedList reverse(LinkedList head){
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
        System.out.println(toString(zipLinkedList(head)));

    }
}
