package c03StackQueue;

import java.util.EmptyStackException;

/**
 * Created by SkinTang on 6/18/17.
 */
public class MyStack <T> {

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public void push(T item) {
        StackNode<T> old = top;
        top = new StackNode<T>(item);
        top.next = old;
    }

    public boolean isEmpty() {
        return (top == null);
    }


    public static void main(String[] args) {
        MyStack<Integer> test = new MyStack<>();
        System.out.println(test.isEmpty());
        for (int i = 0; i < 10; i++) {
            test.push(i);
        }
        for (int i = 0; i < 10; i++) {
            int item = test.pop();
            System.out.println(item);
        }
        System.out.println(test.isEmpty());

    }
}
