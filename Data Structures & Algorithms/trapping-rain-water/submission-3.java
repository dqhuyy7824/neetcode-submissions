class Solution {
    public int trap(int[] height) {
        Stack<Entry> stacks = new Stack<>();
        int total = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stacks.isEmpty() && stacks.peek().height <= height[i]) {

                Entry bottom = stacks.pop();

                if (stacks.isEmpty()) {
                    break;
                }

                Entry left = stacks.peek();

                int width = i - left.index - 1;
                int boundedHeight = Math.min(left.height, height[i]) - bottom.height;

                total += width * boundedHeight;
            }

            stacks.push(new Entry(height[i], i));
        }

        return total;
    }

    record Entry(int height, int index) {}
}