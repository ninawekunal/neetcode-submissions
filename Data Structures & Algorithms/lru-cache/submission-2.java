class LRUCache {
    
    class Node {
        Node prev, next;
        int key, val;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
        public Node() {}

        @Override
        public String toString() {
            String previous = this.prev != null ? ""+this.prev.val : "";
            String nextVal = this.next != null ? ""+this.next.val : "";
            return "" + previous + "<-" + this.val + "->" + nextVal;
        }
    }

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        // Key in map
        // remove node from LL

        Node node = map.get(key);
        removeNode(node);
        
        insertAtFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            insertAtFront(node);
            return;
        } 
        
        if (map.size() == capacity) {
            // time to evict from tail;
            Node toRemove = tail.prev;
            removeNode(toRemove);
            map.remove(toRemove.key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtFront(newNode);
    }
    void removeNode (Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void insertAtFront (Node node) {
        Node headsNext = head.next;
        headsNext.prev = node;
        node.next = headsNext;
        node.prev = head;
        head.next = node;
    }
}
