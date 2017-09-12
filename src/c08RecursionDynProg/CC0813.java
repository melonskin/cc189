package c08RecursionDynProg;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * Stack of Boxes
 * n boxes, wi x hi x di
 */
public class CC0813 {
    private class Box implements Comparable<Box>{
        public int width;
        public int height;
        public int depth;
        public boolean canBeTop(Box that) {
            return (this.width < that.width && this.height < that.height && this.depth < that.depth);
        }

        @Override
        public int compareTo(Box that) {
            if (this.depth > that.depth) {
                return -1;
            } else if (this.depth < that.depth) {
                return 1;
            }
            return 0;
        }
    }

    public int maxStackHeight(List<Box> stack) {
        Collections.sort(stack);
        int maxHeight = 0;
        int[] memo = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            int height = maxStackHeight(stack, i, memo);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    private int maxStackHeight(List<Box> stack, int index, int[] memo) {
        if (index == stack.size()) {
            return 0;
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        int maxHeight = 0;
        Box bottom = stack.get(index);
        for (int i = index + 1; i < stack.size(); i++) {
            if (stack.get(i).canBeTop(bottom)) {
                int height = maxStackHeight(stack, index + 1, memo);
                maxHeight = Math.max(maxHeight, height);
            }
        }
        maxHeight += bottom.height;
        memo[index] = maxHeight;
        return memo[index];
    }

    public int maxStackHeight2(List<Box> boxes) {
        Collections.sort(boxes);
        int[] memo = new int[boxes.size()];
        return maxStackHeight2(boxes, null, 0, memo);
    }

    private int maxStackHeight2(List<Box> boxes, Box bottom, int botIndex, int[] memo) {
        if (botIndex >= boxes.size()) {
            return 0;
        }
        Box newBottom = boxes.get(botIndex);
        int heightWithBot = 0;
        if (bottom == null || newBottom.canBeTop(bottom)) {

            if (memo[botIndex] == 0) {
                memo[botIndex] = maxStackHeight2(boxes, newBottom, botIndex + 1, memo);
                memo[botIndex] += newBottom.height;
            }
            heightWithBot = memo[botIndex];
        }
        int heightWithoutBot = maxStackHeight2(boxes, bottom, botIndex + 1, memo);
        return Math.max(heightWithBot, heightWithoutBot);
    }
}
