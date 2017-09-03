package c02LinkedList;

/**
 * Created by SkinTang on 6/15/17.
 */
public class Runner {
    public void run(LinkedListImpl l) {
        Node p1 = l.getHead();
        Node p2 = l.getHead();

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = l.getHead();

        while (p1 != null) {
            System.out.print(p2.data);
            System.out.print(p1.data);
            p1 = p1.next;
            p2 = p2.next;
        }

    }

    public static void main(String[] args) {
        LinkedListImpl l = new LinkedListImpl(1);
        for (int i = 2; i <= 8; i++) {
            l.appendToTail(i);
        }

        Runner test = new Runner();
        test.run(l);

    }
}
