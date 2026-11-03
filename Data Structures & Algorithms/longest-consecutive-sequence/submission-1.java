class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int maxLength = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int count = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }

            
        }

        return maxLength;
    }
}
