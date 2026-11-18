class Solution {

    Set<Integer> seen = new HashSet<>();
    Set<Integer> done = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> preMap = buildAdjList(prerequisites);
        for (int course: preMap.keySet()) {
            if (!dfs(course, preMap)) return false;
        }
        return true;
    }

    boolean dfs(int course, Map<Integer, List<Integer>> preMap) {
        if (done.contains(course)) return true; // already proven
        if (seen.contains(course)) return false;
        if (preMap.get(course).size() == 0) return true; 
        
        seen.add(course);

        for (int preReq: preMap.getOrDefault(course, List.of())) {
            if(!dfs(preReq, preMap)) return false;
        }
        seen.remove(course);
        done.add(course);
        return true;
    }

    Map<Integer, List<Integer>> buildAdjList(int[][] pre) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for (int[] edge: pre) {
            int c1 = edge[0];
            int c2 = edge[1];
            preMap.computeIfAbsent(c2, k -> new ArrayList<>()).add(c1);
            preMap.computeIfAbsent(c1, k -> new ArrayList<>());
        }
        return preMap;
    }

}
