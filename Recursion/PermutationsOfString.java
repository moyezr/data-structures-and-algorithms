package Recursion;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsOfString {

    public static void main(String[] args) {
        System.out.println(permutationsRet("", "abc"));
    }

    static void permuations(String p, String up) {
        if(up.isEmpty()) {
            System.out.print("[" + p + "] ");
            return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permuations(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> permutationsRet(String p, String up) {
        if(up.isEmpty()) {
         ArrayList<String> list = new ArrayList<>();
         list.add(p);
         return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsRet(f + ch + s, up.substring(1)));
        }

        return ans;
    }

}
