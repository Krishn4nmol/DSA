import java.util.*;
public class twosum {
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
    static void print(Node head, int target) { // TC O(n) SC O(1)
        if (head == null) return;
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }
        while (left != null && right != null && left != right && left.prev != right) {
            int sum = left.data + right.data;
            if (sum == target) {
                System.out.println(left.data + " " + right.data);
                left = left.next;
                right = right.prev;
            }
            else if (sum < target) {
                left = left.next;
            }
            else {
                right = right.prev;
            }
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
                newNode.prev = tail;
                tail = newNode;
            }
        }
        int target = sc.nextInt();
        print(head, target);
    }
}