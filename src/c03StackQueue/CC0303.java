package c03StackQueue;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by SkinTang on 7/7/17.
 * Stack of Plates:
 * Imagine a (literal) stack of plates.
 * If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack
 * when the previous stack exceeds some threshold.
 * Implement a data structure **SetOfStacks** that mimics this.
 * SetOfStacks should be composed of several stacks and
 * should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically
 * to a single stack (that is, pop() should return the same values as
 * it would if there were just a single stack).
 *
 * FOLLOW UP
 * Implement a function popAt(int index)
 * which performs a pop operation on a specific sub-stack.
 *
 * Hints:#64, #81
 */
public class CC0303<T> {
    private Stack<Stack<T>> stackOfStack;
    private final int maxPlateLimit = 10;
    private int noPlateFirstStack;
    CC0303() {
        stackOfStack = new Stack<>();
        noPlateFirstStack = 0;
    }

    public boolean isEmpty() {
        return (noPlateFirstStack == 0 || stackOfStack.empty());
    }
    public void push(T item) {
        if (noPlateFirstStack < maxPlateLimit && noPlateFirstStack != 0) {
            Stack<T> top = stackOfStack.pop();
            top.push(item);
            noPlateFirstStack++;
            stackOfStack.push(top);
        } else {
            Stack<T> newTop = new Stack<>();
            newTop.push(item);
            stackOfStack.push(newTop);
            noPlateFirstStack = 1;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Stack<T> top = stackOfStack.pop();
        T item = top.pop();
        if (!top.isEmpty()) {
            stackOfStack.push(top);
            noPlateFirstStack--;
        } else if (isEmpty()) {
            noPlateFirstStack = 0;
        } else {
            noPlateFirstStack = maxPlateLimit;
        }
        return item;
    }

    public T popAt(int i) {
        Stack<Stack<T>> before = new Stack<>();
        while (i > 0) {
            Stack<T> top = stackOfStack.pop();
            before.push(top);
            i--;
        }
        Stack<T> top = stackOfStack.pop();
        T item = top.pop();
        if (!top.isEmpty()) {
            stackOfStack.push(top);
        }
        while (!before.isEmpty()) {
            Stack<T> one = before.pop();
            stackOfStack.push(one);
        }
        return item;
    }
}
