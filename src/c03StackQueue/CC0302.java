package c03StackQueue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by SkinTang on 7/7/17.
 * Stack Min:
 * How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 * Hints:#27, #59, #78
 *
 */
public class CC0302<T> {

    private static class StackNodeWithMin<T> {
        private T data;
        private StackNodeWithMin<T> next;
        private T min;
        public StackNodeWithMin(T data) {
            this.data = data;
        }
    }

    private static class StackNode {
        private int data;
        private StackNode next;
        public StackNode(int data) {
            this.data = data;
        }
    }

    private class StackWithMin2 {
        private StackNode top;
        private Stack<Integer> minStack;

        public StackWithMin2() {
            minStack = new Stack<>();
        }

        public void push(int item) {
            StackNode n = new StackNode(item);
            if (isEmpty()) {
                top = n;
            } else {
                StackNode old = top;
                top = n;
                top.next = old;
            }
            if (minStack.isEmpty() || top.data <= minStack.peek()) {
                minStack.push(top.data);
            }
        }

        public int pop() {
            int returnItem;
            if (isEmpty()) {
                throw new EmptyStackException();
            } else {
                StackNode oldTop = top;
                top = top.next;
                returnItem = oldTop.data;
                if (returnItem <= minStack.peek()) {
                    minStack.pop();
                }
            }
            return returnItem;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

//    private class StackWithMin<T> {
//
//        private StackNodeWithMin<T> top;
//        private T min;
//
//        public T pop() {
//            if (top == null) throw new EmptyStackException();
//            T item = top.data;
//            top = top.next;
//            min = top.min;
//            return item;
//        }
//
//        public T peek() {
//            if (top == null) throw new EmptyStackException();
//            return top.data;
//        }
//
//        public void push(T item) {
//            StackNodeWithMin<T> old = top;
//            if ((double) item < (double) min) {
//                min = item;
//            }
//            top = new StackNodeWithMin<T>(item);
//            top.min = min;
//            top.next = old;
//        }
//
//        public T getMin() {
//            return min;
//        }
//
//        public boolean isEmpty() {
//            return (top == null);
//        }
//    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

}
