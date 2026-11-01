class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(
                num,
                frequencyMap.getOrDefault(num, 0) + 1
            );
        }

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) 
            buckets.add(new ArrayList<>());
        
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            buckets.get(frequency).add(num);
        }
        
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int num : buckets.get(i)) {
                result[index++] = num;

                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
