import java.util.*;
public class deleteathead {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node deleteAtHead(Node head) { // TC O(1) SC O(1)
        if (head == null) {
            return null;
        }
        return head.next;
    }
    static void printList(Node head) { // TC O(n) SC O(1)
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
        head = deleteAtHead(head);
        printList(head);
    }
}