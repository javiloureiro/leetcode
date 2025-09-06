class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int left = 0;
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for(int i = 0; i < s1.length(); i++){
            countS1[s1.charAt(i) - 'a']++;
        }

        for(int right = 0; right < s2.length(); right++){
            countS2[s2.charAt(right) - 'a']++;

            while(right - left + 1  > s1.length()){
                countS2[s2.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(countS1, countS2)){
                return true;
            }
        }

        return false;
    }
}
