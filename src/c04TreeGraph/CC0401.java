package c04TreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SkinTang on 7/12/17.
 * Route Between Nodes:
 * Given a directed graph,
 * design an algorithm to find out
 * whether there is a route between two nodes
 *
 * Hint: #127
 */
public class CC0401 {
    private static class GraphNode {
        public int data;
        public GraphNode[] nexts;
        public boolean visited;
    }

    private boolean hasRouteBFS(GraphNode n1, GraphNode n2) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(n1);

        while (!queue.isEmpty()) {
            GraphNode n = queue.remove();
            n.visited = true;
            if (n == n2) {
                return true;
            }
            for (GraphNode child : n.nexts) {
               if (child.visited) {
                   continue;
               }
               queue.add(child);
            }
        }
        return false;
    }
}
