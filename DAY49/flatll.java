import java.util.*;
public class flatll {
    static class Node {
        int data;
        Node next;
        Node child;
        Node(int data) {
            this.data = data;
        }
    }
    static Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            a.child = merge(a.child, b);
            return a;
        }
        else {
            b.child = merge(a, b.child);
            return b;
        }
    }
    static Node flatten(Node head) { // TC O(n^2) SC O(n)
        if (head == null || head.next == null) {
            return head;
        }
        head.next = flatten(head.next);
        head = merge(head, head.next);
        return head;
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);
        head.next = new Node(10);
        head.next.child = new Node(20);
        head.next.next = new Node(19);
        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);
        head.next.next.next = new Node(28);
        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);
        Node result = flatten(head);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.child;
        }
    }
}