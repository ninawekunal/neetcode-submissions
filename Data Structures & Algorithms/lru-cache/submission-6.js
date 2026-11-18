class Node { 
    key = "";
    val = "";
    prev = null;
    next = null;

    constructor(key, val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    
    head = new Node();
    tail = new Node();
    capacity;
    map = new Map();
    constructor(capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    get(key) {
        if (this.map.has(key)) {
            const node = this.map.get(key);
            // remove node from the list and insert it at head
            this.deleteNodeFromList(node);
            this.insertNodeAtHead(node);
            return node.val;
        }
        return -1;
    }

    put(key, value) {
        // if key in map, update the value for that key, remove it from the list and put the value at the head.
        if (this.map.has(key)) {
            // update the value for that key in map and node
            const node = this.map.get(key);
            node.val = value;

            // remove it from the list
            this.deleteNodeFromList(node);

            // insert node at head
            this.insertNodeAtHead(node);

        } else {
            // create a new node
            const newNode = new Node(key, value);

            // if map at capacity, then remove the node at tail
            if (this.map.size >= this.capacity) {
                const nodeAtTail = this.tail.prev;
                this.deleteNodeFromList(nodeAtTail);
                // remove tailnode from map too
                this.map.delete(nodeAtTail.key);
            }
            
            // add it to the head of the list
            this.insertNodeAtHead(newNode);

            // add it to the map
            this.map.set(key, newNode);
        }
    }

    deleteNodeFromList(node) {
        const nodesNext = node.next;
        const nodesPrev = node.prev;
        // nodesNext's prev will be nodesPrev
        // nodesPrev's next will be nodesNext
        // node's next and prev will be null
        nodesNext.prev = nodesPrev;
        nodesPrev.next = nodesNext;
        node.next = null;
        node.prev = null;
    }

    insertNodeAtHead(node) {
        // head's next will be the new node
        const oldHeadPlusOne = this.head.next;
        this.head.next = node;

        // new node's prev will be head
        node.prev = this.head;

        // new node's next will be oldHeadPlusOne
        node.next = oldHeadPlusOne;

        // oldHeadPlusOne's prev will be new node
        oldHeadPlusOne.prev = node;
    }
}
