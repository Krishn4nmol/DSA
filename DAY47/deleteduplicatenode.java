import java.util.*;
public class deleteduplicatenode {
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
    static Node delete(Node head) { // TC O(n) SC O(1)
        if (head == null) return null;
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                Node duplicate = curr.next;
                curr.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = curr;
                }
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }
    static Node delete1(Node head) { // TC O(n) SC O(1) for sll
        if (head == null) return null;
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
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
        head = delete(head);
        printList(head);
    }
}