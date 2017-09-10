package c08RecursionDynProg;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Robot in a Grid
 * Hints: 331, 360, 388
 */
public class CC0802 {

    public List<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        List<Point> path = new ArrayList<>();
        Set<Point> failedPointsSet = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPointsSet)) {
            return path;
        }
        return null;
    }
    
    private boolean getPath(boolean[][] maze, int r, int c, List<Point> path, Set<Point> failedPointsSet) {
        if (r < 0 || c < 0 || !maze[r][c] || failedPointsSet.contains(new Point(r, c))) {
            return false;
        }
        boolean isOrigin = r == 0 && c == 0;
        if (isOrigin || getPath(maze, r-1, c, path, failedPointsSet) || 
                getPath(maze, r, c-1, path,failedPointsSet)) {
            path.add(new Point(r, c));
            return true;
        }
        failedPointsSet.add(new Point(r, c));
        return false;
    }
    
}
