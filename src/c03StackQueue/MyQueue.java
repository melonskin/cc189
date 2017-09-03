package c03StackQueue;

import java.util.NoSuchElementException;

/**
 * Created by SkinTang on 6/18/17.
 */
public class MyQueue<T> implements QueueAbs<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;
        public QueueNode(T data) { this.data = data; }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        if (last == null) {
            last = new QueueNode<>(item);
            first = last;
        } else {
            QueueNode<T> newLast = new QueueNode<>(item);
            last.next = newLast;
            last = newLast;
        }
    }

    public T remove() {
        if (this.isEmpty()) throw new NoSuchElementException();
        T item = first.data;
        first = first.next;
        if (first == null) last = null;
        return item;
    }

    public T peek() {
        if (this.isEmpty()) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return (last == null);
    }

    public static void main(String[] args) {
        MyQueue<Integer> test = new MyQueue<>();
        System.out.println(test.isEmpty());
        test.add(100);
        System.out.println(test.peek());
        System.out.println(test.remove());
        for (int i = 0; i < 10; i++) {
            test.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(test.remove());
        }
    }

}
