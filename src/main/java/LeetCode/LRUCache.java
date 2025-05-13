package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }

}

class LRUCache {
    int capacity;
    Map<Integer, Node> dic = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(Node node){
        Node previous = tail.prev;
        previous.next = node;
        node.prev = previous;
        node.next = tail;
        tail.prev = node;
    }



    public int get(int key) {
        if (! dic.containsKey(key)) {
            return -1;
        }

        Node node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)){
            Node node = dic.get(key);
            remove(node);
        }

        Node node = new Node(key, value);
        add(node);
        dic.put(key, node);

        if (dic.size() > capacity) {
            Node oldNode = head.next;
            remove(oldNode);
            dic.remove(oldNode.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
