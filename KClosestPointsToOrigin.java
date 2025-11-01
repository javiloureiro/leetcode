import java.util.AbstractMap;


class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Map.Entry<Integer, int[]>> heap = new PriorityQueue<>(
        (a, b) -> b.getKey() - a.getKey()
    );

        for(int i = 0; i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            heap.offer(new AbstractMap.SimpleEntry<>(dist, new int[]{x, y}));
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i = 0; i < k; i++){
            result[i]= heap.poll().getValue();
        }

        return result;
    }
}
