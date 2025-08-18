class Solution {
    public boolean isAnagram(String s, String t) {
        int i;

        if (s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];

        for(i=0; i < s.length() ; i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count){
            if (c != 0) {
                return false;
            }
        }

        return true;

    }
}
