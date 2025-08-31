class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int middlePos = (left + right) / 2;
            int mid = nums[middlePos];

            if(mid == target){
                return middlePos;
            }
            if (nums[left] <= mid) {
                if(nums[left] <= target && target < mid){
                    right = middlePos - 1;
                }else{
                    left = middlePos + 1;
                }
            }else{
                if(mid < target && target <= nums[right]){
                    left = middlePos + 1;
                }else{
                    right = middlePos - 1;
                }
            }
        }

        return -1;
    }
}
