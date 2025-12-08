class Solution {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visiting = new HashSet<>();
    boolean[] visited;
    List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            map.get(pre).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!dfs(i)) return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    private boolean dfs(int i) {
        if (visiting.contains(i)) return false;
        if (visited[i]) return true;

        visiting.add(i);

        for (int next : map.get(i)) {
            if (!dfs(next)) return false;
        }

        visiting.remove(i);
        visited[i] = true;
        order.add(0, i);
        return true;
    }
}
