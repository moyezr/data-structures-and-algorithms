package Leetcode;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public String lcs(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n + 1][m + 1];

        for(int arr[]: dp) {
            Arrays.fill(arr, -1);
        }

        for(int j = 0; j < m; j++) dp[0][j] = 0;
        for(int i = 0; i < n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j -1 )) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // at this point our dp store the indexes of our lcs.

        String result = "";

        int i = n;
        int j = m;
        while(i > 0 && j > 0) {
            if(s.charAt(i - 1) == t.charAt(j - 1)) {
                result = s.charAt(i - 1) + result;
                i--;
                j--;
            } else {
                if(dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else if(dp[i - 1][j] < dp[i][j - 1]) {
                    j--;
                } else {
                    i--;
                    j--;
                }
            }
        }

        return result;
    }

    public String lps(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        String rev = sb.reverse().toString();

        return lcs(s, rev);
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();


        System.out.println(obj.lcs("abc", "abc"));

        System.out.println("LPS --> " + obj.lps("aacabdkacaa"));
    }

}
