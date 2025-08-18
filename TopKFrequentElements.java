class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.merge(nums[i], 1, Integer::sum);
        }

        return map.entrySet()
            .stream()
            .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}
