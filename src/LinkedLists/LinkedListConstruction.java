package LinkedLists;

public class LinkedListConstruction  {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            if (head==null){
                head = node;
                tail = node;
                return;
            }
            insertAfter(head,node);
        }

        public void setTail(Node node) {
            if (tail == null){
                setHead(node);
                return;
            }
            insertAfter(tail,node);
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;

            if (node.prev == null){
                head = nodeToInsert;
            } else {
                node.prev.next = nodeToInsert;
            }
            node.prev = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (nodeToInsert == head && nodeToInsert == tail) return;
            remove(nodeToInsert);
            nodeToInsert.prev = node;
            nodeToInsert.next = node.next;

            if (node.next == null){
                tail = nodeToInsert;
            } else {
                node.next.prev = nodeToInsert;
            }
            node.next = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            if (position == 1) {
                setHead(nodeToInsert);
                return;
            }
            Node current = head;
            int i = 1;
            while (current!= null && i++ != position) current = current.next;
            if (current != null) insertBefore(current , nodeToInsert);
            else setTail(nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            Node current = head;
            while (current!=null){
                Node toRemove = current;
                current = current.next;
                if (toRemove.value == value) remove(toRemove);
            }
        }

        public void remove(Node node) {
            if (node == head) head = head.next;
            if (node == tail) tail = tail.prev;

            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;

            node.prev = null;
            node.next = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node current = head;
            while (current!=null){
                if (current.value == value){
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
