class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int top = stack.pop();
                int altura = heights[top];
                int ancho = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, altura * ancho);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
