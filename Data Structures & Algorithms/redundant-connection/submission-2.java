class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Integer> parents = new HashMap<>();

        int numNodes = edges.length;
        for (int i = 1; i <= numNodes; i++) {
            parents.put(i, i);
        }

        for (int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!union(n1, n2, parents)) return new int[]{n1, n2};
        }
        return new int[]{};
    }

    boolean union(int n1, int n2, Map<Integer, Integer> parents) {
        int root1 = findRoot(n1, parents);
        int root2 = findRoot(n2, parents);
        if (root1 == root2) return false;

        // combine roots
        parents.put(root1, root2);
        return true;
    }

    int findRoot(int node, Map<Integer, Integer> parents) {
        // recursive
        if (parents.get(node) == node) return node;

        int root = findRoot(parents.get(node), parents);
        return root;
    }
}
