class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int[] numsG;

    public List<List<Integer>> permute(int[] nums) {
        numsG = nums;
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(), used);

        return result;
    }

    public void dfs(List<Integer> curr, boolean[] used){

        if(curr.size() == numsG.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < numsG.length; i++){
            if(used[i] == false){
                curr.add(numsG[i]);
                used[i] = true;
                dfs(curr, used);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
            
        }

    }
}
