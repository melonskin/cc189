package c02LinkedList;

/**
 * Created by SkinTang on 7/5/17.
 * Loop Detection:
 * Given a circular linked list,
 * implement an algorithm that returns the node at the beginning of the loop.
 *
 * DEFINITION
 * Circular linked list:
 * A (corrupt) linked list in which
 * a node's next pointer points to an earlier node,
 * so as to make a loop in the linked list.
 *
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C[the same Casear lier]
 * Output: C
 *
 * Hints: #50, #69, #83, #90
 */
public class CC0208 {
    private Node findCircular(Node head) {
        Node slower = head;
        Node faster = head;
        while (faster != null || faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (faster == slower) {
                break;
            }
        }
        if (faster == null || faster.next == null) {
            return null;
        }

        faster = head;
        while(faster != slower) {
            faster = faster.next;
            slower = slower.next;
        }
        return faster;
    }
}
