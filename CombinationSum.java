class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidatesG;
    int targetG = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidatesG = candidates;
        targetG = target;

        dfs(0, 0, new ArrayList<>());

        return result;
    }

    public void dfs(int i, int sum, List<Integer> curr){

        if(sum == targetG){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(i >= candidatesG.length || sum > targetG){
            return;
        }

        curr.add(candidatesG[i]);

        dfs(i, sum + candidatesG[i], curr);

        curr.remove(curr.size() - 1);

        dfs(i + 1, sum, curr);


    }
}
