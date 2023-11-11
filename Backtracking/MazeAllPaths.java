package Backtracking;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

public class MazeAllPaths {

    public static void main(String[] args) {
        /* Testing for maze with restrictions problem */

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        int arr[][] = new int[3][3];

//        allPath("", maze, 0, 0);

        allPathPrint("", maze, 0, 0, arr, 0);

    }


    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }


        if (!maze[r][c]) {
            return;
        }

        // I am considering this block in my path.
        maze[r][c] = false;

        if (r < maze.length - 1) {
            allPath(p + "D", maze, r + 1, c);
        }

        if (c < maze[0].length - 1) {
            allPath(p + "R", maze, r, c + 1);
        }

        if (r > 0) {
            allPath(p + "U", maze, r - 1, c);
        }

        if (c > 0) {
            allPath(p + "L", maze, r, c - 1);
        }

        // this line is where the function will be over;
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
    }

    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println("\n\n");

            return;
        }

        if (!maze[r][c]) {
            return;
        }

        // I am considering this block in my path.
        maze[r][c] = false;

        path[r][c] = step;

        if (r < maze.length - 1) {
            allPathPrint(p + "D", maze, r + 1, c, path, step + 1);
        }

        if (c < maze[0].length - 1) {
            allPathPrint(p + "R", maze, r, c + 1, path, step + 1);
        }

        if (r > 0) {
            allPathPrint(p + "U", maze, r - 1, c, path, step + 1);
        }

        if (c > 0) {
            allPathPrint(p + "L", maze, r, c - 1, path, step + 1);
        }

        // this line is where the function will be over;
        // so before the function gets removed, also remove the changes that were made by that function
        maze[r][c] = true;
        path[r][c] =0;
    }

}
