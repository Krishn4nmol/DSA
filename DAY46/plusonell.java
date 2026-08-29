import java.util.*;
public class plusonell {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node plusone(Node head) { // TC O(n) SC O(1)
        head = reverse(head);
        Node curr = head;
        int carry = 1;
        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new Node(carry);
        }
        return reverse(head);
    }
    static Node plusone1(Node head) {
        int carry = plusonerec(head);
        if (carry == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
    static int plusonerec(Node node) { // TC O(n) SC O(n)
        if (node.next == null) {
            int sum = node.data + 1;
            node.data = sum % 10;
            return sum / 10;
        }
        int carry = plusonerec(node.next);
        if (carry == 1) {
            int sum = node.data + carry;
            node.data = sum % 10;
            return sum / 10;
        }
        return 0;
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
        head = plusone(head);
        printList(head);
    }
}