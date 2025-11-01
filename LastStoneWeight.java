class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i< stones.length; i++){
            maxHeap.offer(stones[i]);
        }

        while(maxHeap.size() > 1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 != stone2){
                maxHeap.offer(stone1 - stone2);
            }
        }

        if(maxHeap.isEmpty()){
            return 0;
        }
        
        return maxHeap.poll();



    }
}
