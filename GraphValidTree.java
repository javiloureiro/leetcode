class Solution {

    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> graph = new ArrayList<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        if (!dfs(0, -1)) return false;

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent){

        visited.add(node);

        for(int next : graph.get(node)){
            if(next == parent){
                continue;
            }
            if(visited.contains(next)){
                return false;
            }
            if(!dfs(next, node)) return false;
        }

        return true;
    }
}
