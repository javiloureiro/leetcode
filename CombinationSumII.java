class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> curr) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break;
            curr.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
