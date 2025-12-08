class Solution {

    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            visited.clear();

            if (graph.containsKey(u) && graph.containsKey(v) && dfs(u, -1, v)) {
                return edge;
            }

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return new int[]{};
    }

    private boolean dfs(int node, int parent, int target) {
        if (node == target) return true;

        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            if (next == parent) continue;
            if (dfs(next, node, target)) return true;
        }

        return false;
    }
}
