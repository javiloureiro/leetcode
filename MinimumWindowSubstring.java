class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        int[] countT = new int[128];
        for (char c : t.toCharArray()) {
            countT[c]++;
        }

        int left = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        int required = t.length();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (countT[c] > 0) {
                required--;
            }
            countT[c]--;

            while (required == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                countT[leftChar]++;
                if (countT[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
