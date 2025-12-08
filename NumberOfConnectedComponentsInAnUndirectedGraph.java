class Solution {

    Set<Integer> visited = new HashSet<>();
    int components = 0;
    List<List<Integer>> graph = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(i);
                components++;
            }
        }

        return components;
    }

    public void dfs(int node){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);

        for(int next: graph.get(node)){
            dfs(next);
        }
    }
}
