package c03StackQueue;

/**
 * Created by SkinTang on 7/7/17.
 */
public class FibonacciWithStack {
    private int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        MyStack<Integer> stack = new MyStack<>();
        stack.push(0);
        stack.push(1);
        while (n > 1) {
            int first = stack.pop();
            int second = stack.pop();
            stack.push(first);
            stack.push(first + second);
            n--;
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        FibonacciWithStack test = new FibonacciWithStack();
        for (int i = 0; i < 10; i++) {
            System.out.println(test.fibonacci(i));
        }
    }
}
