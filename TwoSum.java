class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i;
        int result;
        int pos1;

        for(i=0; i< nums.length; i++){
            
            pos1 = map.getOrDefault(target-nums[i], -1);

            if( pos1 != -1){
                return new int[]{pos1, i};
            }

            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
