import java.util.*;
public class deletenode {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static void delete(Node x) { // TC O(1) SC O(1)
        x.data = x.next.data;
        x.next = x.next.next;
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node find(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
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
        int k = sc.nextInt();
        Node x = find(head, k);
        if (x != null && x.next != null) {
            delete(x);
        }
        printList(head);
    }
}