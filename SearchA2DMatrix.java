class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        

        while (left <= right){
            int middleArray = (left + right) / 2;
            int leftSub = 0;
            int rightSub = matrix[middleArray].length - 1;
            int mid = 0;
            

            while (leftSub <= rightSub){
                int middlePosOfArray = (leftSub + rightSub) / 2;
                mid = matrix[middleArray][middlePosOfArray];
                if(mid == target){
                    return true;
                }

                if(mid > target){
                    rightSub = middlePosOfArray -1;
                }else{
                    leftSub = middlePosOfArray + 1;
                }
            }

            if(mid > target){
                right = middleArray - 1;
            }else{
                left = middleArray + 1;
            }
        }

        return false;
    }
}
