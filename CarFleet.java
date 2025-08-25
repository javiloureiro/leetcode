class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] steps = new double[position.length];
        Stack<Double> stack = new Stack<>();

        int n = position.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> position[b] - position[a]);


        for(int i = 0; i < n; i++){
            int car = idx[i];
            double time = (double)(target - position[car]) / speed[car];
            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }

        return stack.size(); 
    }
}
