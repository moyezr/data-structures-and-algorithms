package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    public static void main(String[] args) {
//        System.out.println(count(3, 3));
//        ArrayList<String> arr = new ArrayList<>();
//
//
//        path(3, 3, "", arr);
//
//        System.out.println(arr);


        /* Testing for maze with restrictions problem */

        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };

        pathWithRestrictions("", maze, 0, 0);

    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }

        int left = count(r - 1, c);
        int right = count(r, c - 1);


        return left + right;
    }

    static void path(int r, int c, String ans, ArrayList<String> arr) {
        if (r == 1 && c == 1) {
            arr.add(ans);
            System.out.print(ans + "  ");
            return;
        }

        if (r  > 1) {
            path(r - 1, c, ans + "D", arr);
        }
        if (c > 1) {
            path(r, c - 1, ans + "R", arr);
        }
    }

    static void pathWithRestrictions(String p, boolean[][] maze, int r, int c)  {
        if(r == maze.length - 1 && c == maze[0].length - 1)  {
            System.out.print(p + " ");
            return;
        }

        if(!maze[r][c]) {
            return;
        }

        if(r < maze.length - 1) {
            pathWithRestrictions(p + "D", maze, r + 1, c);
        }

        if(c < maze[0].length - 1) {
            pathWithRestrictions(p + "R", maze, r, c + 1);
        }
    }


}
