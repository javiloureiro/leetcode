class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i< temperatures.length; i++){
            while (!stack.isEmpty() && stack.peek().getKey() < temperatures[i]){
                Pair<Integer, Integer> prev = stack.pop();
                result[prev.getValue()] = i - prev.getValue();
            }
        
            stack.push(new Pair<>(temperatures[i], i));
        }

        return result;

    }
}
