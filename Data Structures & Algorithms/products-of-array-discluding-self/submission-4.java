class Solution {
    public int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            }
            
        }
     
        int multiNumber = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                multiNumber *= nums[i];
            }
        }

        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (countZero < 2) result[i] = multiNumber;
                else result[i] = 0;
            } else {
                if (countZero > 0) result[i] = 0;
                else result[i] = multiNumber/nums[i];
            }
        }

        return result;
    }
}  
