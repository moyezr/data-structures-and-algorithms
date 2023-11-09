package Recursion;

import java.sql.SQLOutput;

public class Patterns {

    public static void print(int r) {
        if (r == 0) {
           return;
        }
        for(int i = 0; i < r; i++)
            System.out.print("* ");

        System.out.println();
        print(r - 1);
    }

    public static void main(String[] args) {
        print(5);
    }
}
