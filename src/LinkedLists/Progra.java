package LinkedLists;

public class Progra {
    public static void print(LinkedList head){
        LinkedList first = head;
        String list = "";
        if (first == null) System.out.println("Empty List");
        while (first != null){
            list += first.value + ", ";
            first = first.next;
        }
        System.out.println(list.substring(0 , list.length()-2));
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList previous = null;
        LinkedList current = head;
        while (current!= null){
            LinkedList nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var head = new LinkedList(1);
        print(head);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        head.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next = new LinkedList(6);
        print(head);
        print(reverseLinkedList(head));
    }
}
