class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();

        int rows = isConnected.length;
        int cols = isConnected[0].length;

        int provinces = 0;
        for (int i = 0; i < rows; i++) {
            if (!visited.contains(i)) {
                provinces++;
                explore(i, isConnected, visited);
            }
        }
        return provinces;

    }

    void explore(int city, int[][] isConnected, Set<Integer> visited) {
        if (!visited.add(city)) return;

        for (int next = 0; next < isConnected.length; next++) {
            if (isConnected[city][next] == 1) {
                explore(next, isConnected, visited);
            }
        }
    }
}