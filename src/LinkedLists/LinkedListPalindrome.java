package LinkedLists;

public class LinkedListPalindrome {
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
        while (current != null){
            LinkedList nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public static boolean linkedListPalindrome(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedList reversedSecondHalf = reverseLinkedList(slow);
        LinkedList firstHalf = head;

        while (reversedSecondHalf != null){
            if (reversedSecondHalf.value != firstHalf.value) return false;
            reversedSecondHalf = reversedSecondHalf.next;
            firstHalf = firstHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        var head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(0);
        System.out.println(linkedListPalindrome(head));
    }
}
