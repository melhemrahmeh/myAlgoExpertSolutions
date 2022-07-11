package LinkedLists;

public class SumOfLinkedLists {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList result = new LinkedList(-1);
        LinkedList sum = result;
        int carry = 0;
        while (linkedListOne != null || linkedListTwo != null){
            int value1 = 0;
            if (linkedListOne != null) value1 = linkedListOne.value;
            int value2 = 0;
            if (linkedListTwo != null) value2 = linkedListTwo.value;

            int currentSum = value1 + value2 + carry;
            carry = currentSum / 10;
            sum.next = new LinkedList(currentSum%10);

            if (linkedListOne != null) linkedListOne = linkedListOne.next;
            if (linkedListTwo != null) linkedListTwo = linkedListTwo.next;
            sum = sum.next;
        }
        if (carry > 0){
            sum.next = new LinkedList(carry);
            sum = sum.next;
        }
        return result.next;
    }
}
