package LinkedLists;

public class RemoveKthFromEnd {
    public static void print(LinkedList head){
        if (head != null){
            LinkedList current = head;
            String str = "";
            while (current.next != null){
                str += current.value + ", ";
                current = current.next;
            }
            str+=current.value;
            System.out.println("["+str+"]");
        }
        else System.out.println("[]");
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(4);
        head.next.next = new LinkedList(5);
        head.next.next.next = new LinkedList(7);
        print(head);
        print(head);
    }
}
