package LeetCode;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int poped = stack.pop();
        if (poped == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty()? 0 : minStack.peek();
    }
}

