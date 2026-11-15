class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int index = left + (right - left) / 2;

            if (nums[left] > nums[index] && nums[index] < nums[right]) {
                right = index;
            } else if (nums[left] < nums[index] && nums[index] > nums[right]) {
                left = index + 1;
            } else if (nums[left] < nums[index] && nums[index] < nums[right]
                || nums[left] == nums[index] && nums[index] < nums[right]
                || nums[left] < nums[index] && nums[index] == nums[right]
                || nums[left] == nums[index] && nums[index] == nums[right]) {
                return nums[left];
            } else if (nums[left] == nums[index] && nums[index] > nums[right]
                || nums[left] > nums[index] && nums[index] == nums[right]) {
                return nums[right];
            } 
        }

        return nums[left];
    }
}
