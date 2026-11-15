class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (map.containsKey(c)) {
                int end = map.get(c) + 1;
                while (left < end) {
                    map.remove(s.charAt(left));
                    left++;
                }
            } 

            map.put(c, right);

            max = Math.max(max, map.size());
        }

        return max;
    }
}
