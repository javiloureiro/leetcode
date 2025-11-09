class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    int[] numsGlobal;

    public void dfs(int i) {
        if (i >= numsGlobal.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(numsGlobal[i]);
        dfs(i + 1);

        subset.remove(subset.size() - 1);
        dfs(i + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        numsGlobal = nums;
        dfs(0);
        return result;
    }
}
