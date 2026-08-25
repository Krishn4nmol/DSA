import java.util.*;
public class revsllrec {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node reverse(Node head) { // TC O(n) SC O(n) backtracking
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    static Node reverse1(Node temp, Node prev) { // TC O(n) SC O(n)
        if (temp == null) {
            return prev;
        }
        Node front = temp.next;
        temp.next = prev;
        prev = temp;
        temp = front;
        return reverse1(temp, prev);
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
                tail = newNode;
            }
        }
        printList(head);
        head = reverse(head);
        head = reverse1(head, null);
        printList(head);
    }
}