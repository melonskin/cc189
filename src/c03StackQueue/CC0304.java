package c03StackQueue;

import java.util.Stack;
/**
 * Created by SkinTang on 7/7/17.
 * Queue via Stacks:
 * Implement a MyQueue class which implements a queue using two stacks.
 * Hints: #98, #114
 */
public class CC0304 {
    private class MyQueue<T> {
        private Stack<T> newestStack;
        private Stack<T> oldestStack;

        MyQueue() {
            newestStack = new Stack<>();
            oldestStack = new Stack<>();
        }
        public boolean isEmpty() {
            return newestStack.isEmpty();
        }

        public void add(T item) {
            if (oldestStack.isEmpty()) {
                newestStack.push(item);
            } else {
                while (!oldestStack.isEmpty()) {
                    T one = oldestStack.pop();
                    newestStack.push(one);
                }
            }
        }

        public T remove() {
            if (newestStack.isEmpty()) {
                return oldestStack.pop();
            }
            while (!newestStack.isEmpty()) {
                T item = newestStack.pop();
                oldestStack.push(item);
            }
            return oldestStack.pop();
        }

        public void add2(T item) {
            newestStack.push(item);
        }

        public T remove2() {
            if (oldestStack.isEmpty()) {
                while (!newestStack.isEmpty()) {
                    oldestStack.push(newestStack.pop());
                }
            }
            return oldestStack.pop();
        }
    }
}
