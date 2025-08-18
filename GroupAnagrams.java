class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String clave = new String (chars);
            map.computeIfAbsent(clave, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
