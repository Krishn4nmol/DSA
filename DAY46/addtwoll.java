import java.util.*;
public class addtwoll {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node add(Node head1, Node head2) { // TC O(max(n,m)) SC O(max(n,m))
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            curr.next = new Node(sum % 10);
            curr = curr.next;
            carry = sum / 10;
        }
        return reverse(dummy.next);
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
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
        Node head3 = add(head1, head2);
        printList(head3);
    }
}