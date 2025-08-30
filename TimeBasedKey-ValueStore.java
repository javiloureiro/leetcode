class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> list = map.get(key);
        if (list == null) return "";
        int left = 0;
        int right = list.size() - 1;
        String ans = "";

        while(left <= right){
            int middlePos = (left + right) / 2;
            Pair<Integer, String> mid = list.get(middlePos);
            

            if(mid.getKey() == timestamp){
                return mid.getValue();
            }else if(mid.getKey() < timestamp){
                ans = mid.getValue();
                left = middlePos + 1;
            }else{
                right = middlePos - 1;
            }
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
