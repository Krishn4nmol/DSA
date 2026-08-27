import java.util.*;
public class oddeven {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
        return head;
    }
    static Node segregate(Node head) { // TC O(n) SC O(n)
        if (head == null || head.next == null)
            return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            head = insert(head, sc.nextInt());
        }
        head = segregate(head);
        display(head);
    }
}