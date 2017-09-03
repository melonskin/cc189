package c03StackQueue;

import java.util.Stack;

/**
 * Created by SkinTang on 7/7/17.
 * Sort Stack:
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack,
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 * Hints:# 15, #32, #43
 */
public class CC0305 {

    private class SortedStack {
        private Stack<Integer> stack;

        SortedStack() {
            stack = new Stack<>();
        }
        public void push(int item) {
            Stack<Integer> tempStack = new Stack<>();
            while (!stack.isEmpty()) {
                int top = stack.pop();
                if (top < item) {
                    tempStack.push(top);
                } else {
                    stack.push(top);
                    break;
                }
            }
            stack.push(item);
            while (!tempStack.isEmpty()) {
                int top = tempStack.pop();
                stack.push(top);
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public void sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) {
                s.push(r.pop());
            }
            r.push(temp);
        }

        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}
