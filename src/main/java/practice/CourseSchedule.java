package practice;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {

        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = new int[][]{{0,1}};
        courseSchedule.canFinish(2,prerequisites);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        if (numCourses == 0) {
            return false;
        }
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            System.out.println(adj.get(i).toString());
        }
        return false;
    }
}
