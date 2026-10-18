import java.util.*;
public class LFUcache { // TC O(n) SC O(capacity)
    static class Node {
        int key, value, freq;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    static class DoublyLinkedList {
        Node head, tail;
        int size;
        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast() {
            if (size == 0) {
                return null;
            }
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
        boolean isEmpty() {
            return size == 0;
        }
    }
    static class LFUCache {
        int capacity;
        int minFreq;
        HashMap<Integer, Node> keyMap;
        HashMap<Integer, DoublyLinkedList> freqMap;
        LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFreq = 0;
            keyMap = new HashMap<>();
            freqMap = new HashMap<>();
        }
        int get(int key) {
            if (!keyMap.containsKey(key)) {
                return -1;
            }
            Node node = keyMap.get(key);
            updateFrequency(node);
            return node.value;
        }
        void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (keyMap.containsKey(key)) {
                Node node = keyMap.get(key);
                node.value = value;
                updateFrequency(node);
                return;
            }
            if (keyMap.size() == capacity) {
                DoublyLinkedList list = freqMap.get(minFreq);
                Node lfu = list.removeLast();
                keyMap.remove(lfu.key);
                if (list.isEmpty()) {
                    freqMap.remove(minFreq);
                }
            }
            Node node = new Node(key, value);
            minFreq = 1;
            DoublyLinkedList list = freqMap.computeIfAbsent(
                1, k -> new DoublyLinkedList()
            );
            list.addFirst(node);
            keyMap.put(key, node);
        }
        private void updateFrequency(Node node) {
            int oldFreq = node.freq;
            DoublyLinkedList oldList = freqMap.get(oldFreq);
            oldList.remove(node);
            if (oldList.isEmpty()) {
                freqMap.remove(oldFreq);
                if (minFreq == oldFreq) {
                    minFreq++;
                }
            }
            node.freq++;
            DoublyLinkedList newList = freqMap.computeIfAbsent(
                node.freq, k -> new DoublyLinkedList()
            );
            newList.addFirst(node);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        LFUCache cache = new LFUCache(capacity);
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