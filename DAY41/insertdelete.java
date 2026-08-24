import java.util.*;
public class insertdelete {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node insertAtHead(Node head, int k) { // TC O(1) SC O(1)
        Node newNode = new Node(k);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }
    static Node insertAtTail(Node head, int k) { // TC O(n) SC O(1)
        Node newNode = new Node(k);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }
    static Node deleteAtHead(Node head) { // TC O(1) SC O(1)
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }
    static Node deleteAtTail(Node head) { // TC O(n) SC O(1)
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Node newNode = new Node(x);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        int k = sc.nextInt();
        head = insertAtHead(head, k);
        head = insertAtTail(head, k);
        head = deleteAtHead(head);
        head = deleteAtTail(head);
        printList(head);
    }
}