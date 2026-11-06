
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Entry> stacks = new Stack<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftIndex = i;

            while (!stacks.isEmpty()
                    && heights[i] <= stacks.peek().height) {

                Entry entry = stacks.pop();

                max = Math.max(
                    max,
                    entry.height * (i - entry.index)
                );

                leftIndex = entry.index;
            }

            stacks.push(new Entry(heights[i], leftIndex));
        }

        while (!stacks.isEmpty()) {
            Entry entry = stacks.pop();

            max = Math.max(
                max,
                entry.height * (heights.length - entry.index)
            );
        }

        return max;
    }

    record Entry(int height, int index) {}
}
