class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stacks = new Stack<>();
        int length = temperatures.length;
        int[] result = new int[length];
        
        for (int i = length - 1; i >= 0; i--) {
            while (true) {
                if (stacks.isEmpty()) {
                    result[i] = 0;
                    break;
                } else if (temperatures[i] >= temperatures[stacks.peek()]) stacks.pop();
                else if (temperatures[i] < temperatures[stacks.peek()]) {
                    result[i] = stacks.peek() - i; 
                    break;
                }
            }
            stacks.push(i);
        }

        return result;
    }
}
