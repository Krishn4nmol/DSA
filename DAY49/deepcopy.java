import java.util.*;
public class deepcopy {
    static class Node {
        int data;
        Node next;
        Node random;
        Node(int data) {
            this.data = data;
        }
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node clone(Node head) { // TC O(n) SC O(1) interweaving
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.data);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copyhead = head.next;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        return copyhead;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n3;
        n2.random = n1;
        n3.random = n4;
        n4.random = n2;
        Node copy = clone(n1);
        System.out.println("Original:");
        printList(n1);
        System.out.println("\nCopy:");
        printList(copy);
    }
}