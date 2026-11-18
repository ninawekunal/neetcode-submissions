/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> clonedMap = new HashMap<>(); // old node -> new node map

        Node clonedFirst = new Node(node.val);
        clonedMap.put(node, clonedFirst);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("processing elements in queue" + queue.size());
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                for (Node neighbor: curr.neighbors) {
                    if (!clonedMap.containsKey(neighbor)) {
                        Node clonedNeighbor = new Node(neighbor.val);
                        clonedMap.put(neighbor, clonedNeighbor);
                        queue.offer(neighbor);
                    }
                    clonedMap.get(curr).neighbors.add(clonedMap.get(neighbor));
                }
            }
        }
        return clonedMap.get(node);
    }
}







