package LinkedLists;

public class Reverse {
    static class LinkedList{
        public int value;
        public LinkedList next;

        public LinkedList(int value){
            this.value = value;
            this.next = null;
        }
    }

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

    public static LinkedList reverse(LinkedList head){
        if (head != null){
            LinkedList current = head;
            LinkedList previous = null;
            while (current != null){
                LinkedList nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }
            return previous;
        }
        else return null;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        head.next.next.next = new LinkedList(4);
        print(head);
        print(reverse(head));
    }
}
