class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int areaLocal;
        int areaGlobal = 0;

        while(left < right){
            areaLocal = Math.min(height[left], height[right]) * (right-left);
            if(areaLocal > areaGlobal){
                areaGlobal = areaLocal;
            }
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            
        }

        return areaGlobal;

    }
}
