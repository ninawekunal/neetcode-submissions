class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> parents = new HashMap<>();
        
        int numNodes = edges.length;
        for (int i = 1; i <= numNodes; i++) {
            parents.put(i, i); // by default each node is itself's parent.
        }

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            
            if (!union(a, b, parents)) {
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }

    boolean union(int n1, int n2, Map<Integer, Integer> parents) { 
        int p1 = findParentNode(n1, parents);
        int p2 = findParentNode(n2, parents);
        if (p1 == p2) return false;
        
        parents.put(p1, p2);
        return true;
    }

    int findParentNode(int node, Map<Integer, Integer> parents) {
        if (parents.get(node) == node) return node;
        int parentNode = findParentNode(parents.get(node), parents);
        parents.put(node, parentNode);
        return parentNode;
    }
}
