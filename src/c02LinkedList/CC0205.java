package c02LinkedList;

/**
 * Created by SkinTang on 7/3/17.
 * Sum Lists:
 * You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order,
 * such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers
 * and returns the sum as a linked list.
 *
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output:2 -> 1 -> 9.That is,912.
 *
 * FOLLOW UP
 * Suppose the digits are stored in forward order.
 * Repeat the above problem.
 *
 * EXAMPLE
 * input:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
 * Output:9 -> 1 -> 2.That is,912.
 * Hints: #7, #30, #71, #95, #109
 */
public class CC0205 {
//    private int getNumFromList(Node n) {
//        int base = 1;
//        int num = 0;
//        while (n != null) {
//            num += n.data * base;
//            base *= 10;
//            n = n.next;
//        }
//        return num;
//    }
//    private int getNumAtDigit(int num, int digit) {
//        return (num / (power(10, digit))) % 10;
//    }
//
//    private int power(int base, int power) {
//        int result = 1;
//        while (power > 0) {
//            result *= base;
//            power--;
//        }
//        return result;
//    }
//    private int getTotalDigit(int num) {
//        int digit = 0;
//        while (num > 0) {
//            digit++;
//            num = num / 10;
//        }
//        return digit;
//    }
//
//    private Node sumTwoListRev(LinkedListImpl l1, LinkedListImpl l2) {
//        Node n1 = l1.getHead();
//        Node n2 = l2.getHead();
//
//        int num1 = getNumFromList(n1);
//        int num2 = getNumFromList(n2);
//
//        int sum = num1 + num2;
//        Node head = new Node(getNumAtDigit(sum, 1));
//        Node result = head;
//        sum /= 10;
//        while (sum > 0) {
//            result.next = new Node(sum % 10);
//            sum /= 10;
//            result = result.next;
//        }
//
//        result.next = null;
//        return head;
//    }
//
//    private int getListLength(LinkedListImpl l) {
//        Node node = l.getHead();
//        int len = 0;
//        while (node != null) {
//            node = node.next;
//            len++;
//        }
//        return len;
//    }
//
//    private int getNumFromList(Node n, int length) {
//        int base = power(10, length-1);
//        int num = 0;
//        while (base > 0) {
//            num += n.data * base;
//            base /= 10;
//            n = n.next;
//        }
//        return num;
//    }
//
//    private LinkedListImpl sumTwoListForWard(LinkedListImpl l1, LinkedListImpl l2) {
//        Node n1 = l1.getHead();
//        Node n2 = l2.getHead();
//        int len1 = getListLength(l1);
//        int len2 = getListLength(l2);
//        int num1 = getNumFromList(n1, len1);
//        int num2 = getNumFromList(n2, len2);
//        int sum = num1 + num2;
//        int sumLen = getTotalDigit(sum);
//        LinkedListImpl l = new LinkedListImpl(getNumAtDigit(sum, --sumLen));
//        while (sumLen > 0) {
//            l.appendToTail(getNumAtDigit(sum,--sumLen));
//        }
//        return l;
//    }

    private Node sumTwoListRevRecur(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        int n1data = (n1 == null) ? 0 : n1.data;
        int n2data = (n2 == null) ? 0 : n2.data;

        Node n1next = (n1 == null) ? null : n1.next;
        Node n2next = (n2 == null) ? null : n2.next;

        Node node = sumTwoListRevRecur(n1next, n2next);
        int num = n1data + n2data;
        if (num >= 10) {
            num -= 10;
            node.data += 1;
        }
        Node oldNode = node;
        while (node != null && node.data >= 10) {
            node.data -= 10;
            if (node.next != null) {
                node.next.data += 1;
                node = node.next;
            } else {
                node.next = new Node(1);
            }
            node = node.next;
        }
        Node newNode = new Node(num);
        newNode.next = oldNode;
        return newNode;
    }

    private Node sumTwoListForwRecur(Node n1, Node n2) {
        int len1 = getListLength(n1);
        int len2 = getListLength(n2);
        int lenDiff = len1 - len2;
        if (lenDiff > 0) {
            n2 = addZero(n2, lenDiff);
        } else if (lenDiff < 0) {
            n1 = addZero(n1, -lenDiff);
        }
        n1 = addZero(n1, 1);
        n2 = addZero(n2, 1);
        Node node = sumTwoListForwRecurInner(n1, n2);
        if (node.data == 0) {
            node = node.next;
        }
        return node;
    }

    private Node addZero(Node node, int num) {
        while (num-- > 0) {
            Node newNode = new Node(0);
            newNode.next = node;
            node = newNode;
        }
        return node;
    }

    private int getListLength(Node node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    private Node sumTwoListForwRecurInner(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        Node node = sumTwoListForwRecurInner(n1.next, n2.next);
        int data = n1.data + n2.data;
        if (node != null && node.data >= 10) {
            data += 1;
            node.data -= 10;
        }
        Node newNode = new Node(data);
        newNode.next = node;
        return newNode;
    }

    private Node sumTwoListRevRecur2(Node n1, Node n2) {
        int carry = 0;
        return sumTwoListRevRecur2Inner(n1, n2, carry);
    }

    private Node sumTwoListRevRecur2Inner(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }
        int sum = 0;
        if (n1 != null) {
            sum += n1.data;
        }
        if (n2 != null) {
            sum += n2.data;
        }
        sum += carry;

        Node node = sumTwoListRevRecur2Inner( (n1 == null) ? null : n1.next,
                (n2 == null) ? null : n2.next, (sum >= 10) ? 1 : 0);

        sum %= 10;

        Node newNode = new Node(sum);

        newNode.next = node;

        return newNode;

    }

    public static void main(String[] args) {
        LinkedListImpl l1 = new LinkedListImpl(7);
        l1.appendToTail(1);
        l1.appendToTail(6);
        LinkedListImpl l2 = new LinkedListImpl(5);
        l2.appendToTail(9);
        l2.appendToTail(3);
        CC0205 test = new CC0205();

//        Node head = test.sumTwoListRev(l1, l2);
//        while (head != null) {
//            System.out.println(head.data);
//            head = head.next;
//        }

        // recursive test reverse order
        Node node = test.sumTwoListRevRecur2(l1.getHead(), l2.getHead());
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }


        // recursive test
//        Node n1 = l1.getHead();
//        Node n2 = l2.getHead();
//        Node ns = test.sumTwoListForwRecur(n1, n2);
//        while (ns != null) {
//            System.out.println(ns.data);
//            ns = ns.next;
//        }

    }
}
