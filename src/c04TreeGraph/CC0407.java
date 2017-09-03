package c04TreeGraph;

import java.util.*;

/**
 * Created by SkinTang on 7/14/17.
 *
 * Build Order:
 * You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the second projects is dependent on the first project).
 * All of a project's dependencies must be built before the projects is.
 * Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error
 *
 *
 * EXAMPLE:
 * input:
 * projects: a, b, c, d, e, f
 * dependencies: (a,d), (f,b), (b,d), (f,a), (d,c)
 *
 * Output: f, e, a, b, d, c
 *
 * Hints: #26, 47, 60, 85, 125, 133
 */
public class CC0407 {
    private static class ProjectNode {
        public String project;
        public List<ProjectNode> parents;
        public List<ProjectNode> children;
        public boolean visited;
        public ProjectNode(String project) {
            this.project = project;
        }
    }
    private static class Depend {
        public String father;
        public String son;
    }
    public Queue<String> isValid(String[] projects, Depend[] depends) {
        Queue<String> result = new LinkedList<>();
        Queue<ProjectNode> heads = new LinkedList<>();
        Map<String, ProjectNode> map = new HashMap<>();
        for (Depend depend : depends) {
            String father = depend.father;
            String son = depend.son;
            if (!map.containsKey(father)) {
                ProjectNode fatherNode = new ProjectNode(father);
                fatherNode.children = new ArrayList<>();
                fatherNode.parents = new ArrayList<>();
                map.put(father, fatherNode);
                heads.add(fatherNode);
            }
            if (!map.containsKey(son)) {
                ProjectNode sonNode = new ProjectNode(son);
                sonNode.parents = new ArrayList<>();
                sonNode.children = new ArrayList<>();
                map.put(son, sonNode);
            }
            List<ProjectNode> sonList = map.get(father).children;
            sonList.add(map.get(son));
            List<ProjectNode> fatherList = map.get(son).parents;
            fatherList.add(map.get(father));
            heads.remove(map.get(son));
        }
        while (!heads.isEmpty()) {
            ProjectNode head = heads.remove();
            result.add(head.project);
            head.visited = true;
            if (head.children == null || head.children.isEmpty()) {
                continue;
            }
            for (ProjectNode child : head.children) {
                child.parents.remove(head);
                if (!child.visited && child.parents.isEmpty()) {
                    heads.add(child);
                }
            }
        }
        if (result.size() != projects.length) {
            return null;
        }
        return result;
    }

    public static void main(String[] args) {
    }

}
