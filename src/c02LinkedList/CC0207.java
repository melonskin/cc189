package c02LinkedList;

/**
 * Created by SkinTang on 7/5/17.
 * Intersection:
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return the inter­secting node.
 * Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is
 * the exact same node (by reference) as the jth node of the second linked list,
 * then they are intersecting.
 *
 * Hints:#20, #45, #55, #65, #76, #93, #111, #120, #129
 */
public class CC0207 {
    private Node matchBruteForce(Node n1, Node n2) {
        Node n2Node = n2;
        while (n1 != null) {
            while (n2Node != null ) {
                if (n1 == n2Node) {
                    return n1;
                }
                n2Node = n2Node.next;
            }
            n1 = n1.next;
        }
        return null;
    }

    private Node match(Node n1, Node n2) {
        Node n1Node = n1;
        Node n2Node = n2;
        int len1 = 1;
        int len2 = 1;
        while (n1Node.next != null) {
            n1Node = n1Node.next;
            len1++;
        }
        while (n2Node.next != null) {
            n2Node = n2Node.next;
            len2++;
        }
        if (n1Node != n2Node) {
            return null;
        }
        n1Node = n1;
        n2Node = n2;
        while (len1 > len2) {
            n1Node = n1Node.next;
            len1--;
        }

        while (len1 < len2) {
            n2Node = n2Node.next;
            len2--;
        }

        while (n1Node != n2Node) {
            n1Node = n1Node.next;
            n2Node = n2Node.next;
        }
        return n1Node;
    }
}
