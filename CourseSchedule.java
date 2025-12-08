class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    HashSet<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            map.get(pre).add(course);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited.contains(i)){
                if(!dfs(i)) return false;
            }
        }

        return true;

    }

    private boolean dfs(int i){
        if(visiting.contains(i)){
            return false;
        }
        if(visited.contains(i)) return true;

        visiting.add(i);
        
        for (int next : map.get(i)) {
            if (!dfs(next)) return false;
        }

        visiting.remove(i);
        visited.add(i);
        return true;
    }
}
