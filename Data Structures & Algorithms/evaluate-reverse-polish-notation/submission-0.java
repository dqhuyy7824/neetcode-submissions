class Solution {
    public int evalRPN(String[] tokens) {
        int[] nums = new int[tokens.length];
        int length = 0;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            switch (token) {
                case "+" -> {
                    int b = nums[--length];
                    int a = nums[--length];
                    nums[length++] = a + b;
                }
                case "-" -> {
                    int b = nums[--length];
                    int a = nums[--length];
                    nums[length++] = a - b;
                }
                case "*" -> {
                    int b = nums[--length];
                    int a = nums[--length];
                    nums[length++] = a * b;
                }
                case "/" -> {
                    int b = nums[--length];
                    int a = nums[--length];
                    nums[length++] = a / b;
                }
                default -> nums[length++] = Integer.parseInt(token);
            }
        }

        return nums[0];
    }
}