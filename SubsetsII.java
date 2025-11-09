class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] numsG;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        numsG = nums;
        
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<Integer> curr){

        for(int i = start; i < numsG.length; i++){


            if(i > start && numsG[i] == numsG[i-1]) continue;
            curr.add(numsG[i]);
            result.add(new ArrayList<>(curr));

            dfs(i+1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
