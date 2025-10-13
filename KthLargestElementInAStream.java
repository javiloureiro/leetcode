class KthLargest {
    PriorityQueue<Integer> minHeap;
    int globalK;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        globalK = k;

        for (int num : nums) {
            add(num);
        }

    }
    
    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > globalK) minHeap.poll();

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
