class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int middlePos= (right+left) / 2;
            int middle = nums[middlePos];
            if (middle == target){
                return middlePos;
            }

            if (middle < target){
                left = middlePos + 1;
            }else{
                right = middlePos - 1;
            }
        }

        return -1;
    }
}
