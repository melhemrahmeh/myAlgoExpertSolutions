package LinkedLists;

public class MergeTwoLinkedList {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
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

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList head = new LinkedList(-1);
        LinkedList result = head;

        while (headOne!=null && headTwo !=null){
            if (headOne.value < headTwo.value){
                head.next = headOne;
                headOne = headOne.next;
            }
            else {
                head.next = headTwo;
                headTwo = headTwo.next;

            }
            head = head.next;
        }
        if (headTwo == null && headOne !=null){
            head.next = headOne;
        }
        if (headOne == null && headTwo !=null){
            head.next = headTwo;
        }
        return result.next;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(4);

        LinkedList head2 = new LinkedList(2);
        head2.next = new LinkedList(3);
        head2.next.next = new LinkedList(5);

        System.out.println(toString(mergeLinkedLists(head , head2)));
    }
}
