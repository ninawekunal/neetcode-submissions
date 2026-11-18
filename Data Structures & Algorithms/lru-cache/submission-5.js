class Node {
    next = null;
    prev = null;
    value;
    key;
    constructor(key, val) {
        this.key = key;
        this.value = val;
    }
}
class LRUCache {
    /**
     * @param {number} capacity
     */
    map;
    capacity;
    head;
    tail;

    constructor(capacity) {
        this.capacity = capacity;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new Map();
    }

    get(key) {
        if (this.map.has(key)) {
            const node = this.map.get(key);
            this.deleteNodeFromList(node);
            this.insertAtHead(node);
            return node.value;
        }
        return -1;
    }

    put(key, value) {
        let node;

        if (this.map.has(key)) {
            node = this.map.get(key);
            this.deleteNodeFromList(node);
        } else {
            // new entry
            node = new Node(key, value);
            if (this.map.size === this.capacity) {
                const tailsPrev = this.tail.prev;
                this.map.delete(tailsPrev.key);
                this.deleteNodeFromList(tailsPrev);
            }
        }
        node.value = value;
        
        this.map.set(key, node);
        this.insertAtHead(node);
    }

    deleteNodeFromList(node) {
        const nodesPrev = node.prev;
        const nodesNext = node.next;
        nodesPrev.next = nodesNext;
        nodesNext.prev = nodesPrev;
    }

    insertAtHead(node) {
        const headsNext = this.head.next; // 1
        node.next = headsNext; 
        node.prev = this.head; 
        headsNext.prev = node;
        this.head.next = node;
    }
}
