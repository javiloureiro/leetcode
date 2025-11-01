class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char t : tasks) {
            freqMap.put(t, freqMap.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            for (int i = 0; i < cycle; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll() - 1);
                }
                time++;
                if (maxHeap.isEmpty() && temp.stream().allMatch(f -> f == 0)) break;
            }

            
            for (int f : temp) {
                if (f > 0) maxHeap.add(f);
            }
        }

        return time;
    }
}
