package c04TreeGraph;

/**
 * Created by SkinTang on 7/14/17.
 */
public class Util {
    class BTNode<T> {
        public T data;
        public BTNode<T> left;
        public BTNode<T> right;

        BTNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
