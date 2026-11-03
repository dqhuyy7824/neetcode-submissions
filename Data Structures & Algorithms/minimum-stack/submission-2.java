class MinStack {
    int[] stacks;
    int[] minStacks;
    int length;
    int index;

    public MinStack() {
        length = 1000;
        stacks = new int[length];
        minStacks = new int[length];

        minStacks[0] = Integer.MAX_VALUE;
        index = 0;
    }

    public void push(int val) {
        if (index == length - 1) {
            length *= 2;
            stacks = Arrays.copyOf(stacks, length);
            minStacks = Arrays.copyOf(minStacks, length);
        }

        index++;

        minStacks[index] = Math.min(val, minStacks[index - 1]);
        stacks[index] = val;
    }

    public void pop() {
        if (index > 0) {
            index--;
        }
    }

    public int top() {
        return stacks[index];
    }

    public int getMin() {
        return minStacks[index];
    }
}