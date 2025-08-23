class MinStack {

    LinkedList<Pair<Integer, Integer>> list = new LinkedList<>();

    public MinStack() {
        list = new LinkedList<>();
    }
    
    public void push(int val) {
        if(list.isEmpty()){
            list.add(new Pair<>(val, val));
        }else{
            int currentMin = list.getLast().getValue();
            if (val < currentMin){
                list.add(new Pair<>(val,val));
            }else{
                list.add(new Pair<>(val, currentMin));
            }
        }
        
    }
    
    public void pop() {
        list.removeLast();

    }
    
    public int top() {
        return list.getLast().getKey();
    }
    
    public int getMin() {
        return list.getLast().getValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
