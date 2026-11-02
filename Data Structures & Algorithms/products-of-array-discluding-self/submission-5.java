class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] numsStartLeft = new int[length];
        numsStartLeft[0] = nums[0];
        for (int i = 1; i < length; i++) {
            numsStartLeft[i] = numsStartLeft[i - 1] * nums[i]; 
        }

        int[] numsStartRight = new int[length];
        numsStartRight[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            numsStartRight[i] = numsStartRight[i + 1] * nums[i]; 
        }

        int[] result = new int[length];
        result[0] = numsStartRight[1];
        result[length - 1] = numsStartLeft[length - 2];
        for (int i = 1; i < length - 1; i++) {
            result[i] = numsStartLeft[i - 1] * numsStartRight[i + 1];
        }

        return result;
    }
}  
