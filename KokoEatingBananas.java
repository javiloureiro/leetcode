class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int p : piles) high = Math.max(high, p);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long horas = 0;
            for (int p : piles) {
                horas += (p + mid - 1L) / mid;
            }

            if (horas <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
