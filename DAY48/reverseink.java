import java.util.*;
public class reverseink {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node reverse(Node head, int k) { // TC O(n) SC O(n/k)
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        Node temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
        }
        Node prev = null;
        Node curr = head;
        for (int i = 0; i < k; i++) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverse(curr, k);
        return prev;
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null, tail = null;
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
        int k = sc.nextInt();
        head = reverse(head, k);
        printList(head);
    }
}