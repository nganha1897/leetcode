class LRUCache {
    int capacity;
    Map<Integer, Node> dict;
    Node head; 
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dict = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        tail.next = head;
        head.prev = tail;
    }
    
    public int get(int key) {
        if (dict.containsKey(key)) {
            Node node = dict.get(key);
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (dict.containsKey(key)) {
            Node node = dict.get(key);
            dict.get(key).val = value;
            remove(node);
            add(node);
            return;
        }
        if (capacity == 0) {
            Node rem = tail.next;
            remove(rem);
            capacity++;
            dict.remove(rem.key);       
        }
        Node node = new Node(key, value);
        add(node);
        dict.put(key, node);
        capacity--;
    }

    private void add(Node node) {
        node.next = head;
        node.prev = head.prev;
        head.prev = node;
        node.prev.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int k, int v) {
        key = k;
        val = v;
    }

    public String toString() {
        return key + "-" + val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */