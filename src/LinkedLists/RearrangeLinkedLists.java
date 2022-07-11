package LinkedLists;

public class RearrangeLinkedLists {
    public static int count(LinkedList head){
        if (head == null) return -1;
        LinkedList first = head;
        int count = 0;
        while (first != null){
            count++;
            first = first.next;
        }
        return count;
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

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        LinkedList lessThanK = new LinkedList(-1);
        LinkedList l1 = lessThanK;
        LinkedList greaterThanK = new LinkedList(-1);
        LinkedList l2 = greaterThanK;
        LinkedList equalToK = new LinkedList(-1);
        LinkedList l3 = equalToK;

        LinkedList current = head;


        while (current != null){
            if (current.value < k){
                lessThanK.next = new LinkedList(current.value);
                lessThanK = lessThanK.next;
            }
            else if (current.value > k) {
                greaterThanK.next = new LinkedList(current.value);
                greaterThanK = greaterThanK.next;
            }
            else {
                equalToK.next = new LinkedList(current.value);
                equalToK = equalToK.next;
            }
            current = current.next;
        }
        if (count(l3) == 1){
            LinkedList node = new LinkedList(k);
            lessThanK.next = node;
            node.next = l2.next;
            return l1.next;

        }
        lessThanK.next = l3.next;
        equalToK.next = l2.next;
        return l1.next;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(0);
        head.next.next = new LinkedList(5);
        head.next.next.next = new LinkedList(2);
        head.next.next.next.next = new LinkedList(1);
        head.next.next.next.next.next = new LinkedList(4);

        System.out.println(toString(head));
        System.out.println(toString(rearrangeLinkedList(head , 3)));
    }
}
