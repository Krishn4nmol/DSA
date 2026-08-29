import java.util.*;
public class intersection {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node intersect(Node head1, Node head2) { // two pointer approach TC O(n+m) SC O(1)
        if (head1 == null || head2 == null) return null;
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }
        return p1;
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
        int m = sc.nextInt();
        Node head1 = null;
        Node tail1 = null;
        Node head2 = null;
        Node tail2 = null;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Node newNode = new Node(x);
            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            }
            else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            Node newNode = new Node(x);
            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            }
            else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }
        Node head3 = intersect(head1, head2);
        printList(head3);
    }
}