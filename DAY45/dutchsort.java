import java.util.*;
public class dutchsort {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node sort(Node head) { // TC O(n) SC O(1)
        if (head == null || head.next == null) {
            return head;
        }
        Node zerodummy = new Node(-1);
        Node onedummy = new Node(-1);
        Node twodummy = new Node(-1);
        Node zero = zerodummy;
        Node one = onedummy;
        Node two = twodummy;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            }
            else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = onedummy.next != null ? onedummy.next : twodummy.next;
        one.next = twodummy.next;
        two.next = null;
        return zerodummy.next;
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
        head = sort(head);
        printList(head);
    }
}