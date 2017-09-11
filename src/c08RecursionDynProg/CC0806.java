package c08RecursionDynProg;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SkinTang on 9/10/17.
 * Hanoi Tower
 */
public class CC0806 {
    private class Tower {
        private int index;
        private Stack<Integer> disks;
        public Tower(int index) {
            this.index = index;
            this.disks = new Stack<>();
        }
        public void add(int i) {
            disks.push(i);
        }
        private int removeTop() {
            return disks.pop();
        }

        private void moveTop(Tower destination) {
            int top = this.removeTop();
            destination.add(top);
        }

        public void moveDisks(int n, Tower buffer, Tower destination) {
            if (n == 0) {
                return;
            }
            moveDisks(n - 1, destination, buffer);
            moveTop(destination);
            buffer.moveDisks(n - 1, this, destination);
        }

    }
    public void main() {
        int n = 3; // number of towers
        int nDisks = 3; // number of disks
        List<Tower> towerList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            towerList.add(new Tower(i));
        }
        Tower originTower = towerList.get(0);
        // setup
        for (int i = nDisks - 1; i >= 0; i--) {
            originTower.add(i);
        }
        originTower.moveDisks(nDisks, towerList.get(1), towerList.get(2));
    }
}
