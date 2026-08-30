import java.util.*;
public class deletenodewithtarget {
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
    static Node delete(Node head, int target) { // TC O(n) SC O(1)
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) {
                if (curr == head) {
                    head = curr.next;
                }
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                }
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return head;
    }
    static Node delete1(Node head, int target) { // TC O(n) SC O(1) for sll
        Node curr = head;
        while (curr != null) {
            if (curr == head && curr.data == target) {
                head = curr.next;
                curr = head;
            }
            else if (curr.next != null && curr.next.data == target) {
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
        int target = sc.nextInt();
        head = delete(head, target);
        printList(head);
    }
}