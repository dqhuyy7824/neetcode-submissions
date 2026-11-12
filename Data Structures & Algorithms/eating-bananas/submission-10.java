
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        while (min <= max) {
            int k = min + (max - min) / 2;

            long sum = 0;

            for (int pile : piles) {
                sum += ((long) pile + k - 1) / k;
                
            }

            if (sum > h) {
                min = k + 1;
            } else {
                max = k - 1;
            }
        }

        return min;
    }
}
