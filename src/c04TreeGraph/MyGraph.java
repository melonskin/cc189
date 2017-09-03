package c04TreeGraph;

import c03StackQueue.MyQueue;

/**
 * Created by SkinTang on 6/19/17.
 */
public class MyGraph<T> {
    private static class GraphNode<T> {
        private T data;
        private GraphNode<T>[] adjacent;
        private boolean visited;
    }

    public GraphNode<T>[] nodes;

    public void visit(GraphNode<T> node) {
    }

    public void searchDFS(GraphNode<T> root) {
        if (root == null) return;
        visit(root);
        root.visited = true;
        for (GraphNode<T> item : root.adjacent) {
            if (item.visited) continue;
            searchDFS(item);
        }
    }

    public void searchBFS(GraphNode<T> root) {
        MyQueue<GraphNode<T>> queue = new MyQueue<>();
        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode<T> item = queue.remove();
            visit(item);
            item.visited = true;
            for (GraphNode<T> child : item.adjacent) {
                if (!child.visited) {
                    child.visited = true;
                    queue.add(child);
                }

            }
        }


    }
}
