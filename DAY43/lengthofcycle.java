import java.util.*;
public class lengthofcycle {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static int find(Node head) { // TC O(n) SC O(1) Floyd's Cycle Detection Algo
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                Node temp = slow.next;
                int count = 1;
                while (temp != slow) {
                    temp = temp.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
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
        tail.next = head.next;
        System.out.println(find(head));
    }
}