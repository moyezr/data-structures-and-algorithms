package Recursion;

import java.sql.SQLOutput;

public class Patterns {

    public static void triangle(int r, int c) {
        if (r == 1) {
            return;
        }
        if (c == 1) {
            System.out.println();
            triangle(r - 1, r - 1);
        } else {
            System.out.print("* ");
            triangle(r, c - 1);
        }
    }

    public static void main(String[] args) {
        triangle(6, 6);
    }
}
