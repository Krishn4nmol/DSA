import java.util.*;
public class revdllrec {
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
    static Node reverse(Node head) { // TC O(n) SC O(n) backtracking
        if (head == null || head.next == null) {
            if (head != null) {
                head.prev = null;
            }
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        return newHead;
    }
    static Node reverse1(Node temp, Node newHead) { // TC O(n) SC O(n)
        if (temp == null) {
            return newHead;
        }
        Node front = temp.next;
        temp.next = temp.prev;
        temp.prev = front;
        newHead = temp;
        temp = front;
        return reverse1(temp, newHead);
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
        printList(head);
        head = reverse(head);
        head = reverse1(head, null);
        printList(head);
    }
}