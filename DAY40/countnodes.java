import java.util.*;
public class countnodes {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static int count(Node head) { // TC O(n) SC O(1)
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
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
        System.out.println(count(head));
    }
}