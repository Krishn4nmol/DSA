import java.util.*;
public class LRUcache { // TC O(n) SC O(capacity)
    static class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    static class LRUCache {
        int capacity;
        HashMap<Integer, Node> map;
        Node head, tail;
        LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        void insertAtFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        void moveToFront(Node node) {
            remove(node);
            insertAtFront(node);
        }
        int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToFront(node);
            return node.value;
        }
        void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToFront(node);
                return;
            }
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            insertAtFront(node);
            map.put(key, node);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        LRUCache cache = new LRUCache(capacity);
        for (int i = 0; i < n; i++) {
            int operation = sc.nextInt();
            if (operation == 1) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                cache.put(key, value);
                System.out.print("null ");
            } else if (operation == 2) {
                int key = sc.nextInt();
                System.out.print(cache.get(key) + " ");
            }
        }
        sc.close();
    }
}