class Solution {
    public int trap(int[] height) {
        int output = 0;
        int total = 0;
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];
        for (int i = 1; i< n; i++){
                maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        maxRight[n-1] = height[n-1];
        for(int i = n-2; i>0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        for(int i = 0; i< n; i++){
            total += Math.max(0, Math.min(maxLeft[i], maxRight[i])-height[i]);
        }

        return total;
        
    }
}
