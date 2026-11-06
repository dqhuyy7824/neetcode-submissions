class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Entry> stacks = new Stack<>();
        int max = heights[0];
        stacks.push(new Entry(heights[0], 0));

        for (int i = 1; i < heights.length; i++) {
            Entry newEntry = new Entry(0, 0);
            boolean check = false;
            max = Math.max(max, heights[i]);

            while (!stacks.isEmpty()) {
                
                Entry entry = stacks.peek();

                if (heights[i] <= entry.height) {
                    newEntry = new Entry(heights[i], entry.index);
                    stacks.pop();
                    max = Math.max(max, heights[i] * (i - entry.index + 1));
                    check = true;
                } else break;
            }

            if (!check) newEntry = new Entry(heights[i], i);

            Stack<Entry> fakeStacks = new Stack<>();
            fakeStacks.addAll(stacks);

            while (!fakeStacks.isEmpty()) {
                Entry entry = fakeStacks.pop();
                max = Math.max(max, entry.height * (newEntry.index - entry.index + 1));
            }

            stacks.push(newEntry);
        }

        return max;
    }

    record Entry(int height, int index) {}
}