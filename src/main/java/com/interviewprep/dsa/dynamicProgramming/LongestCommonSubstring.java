package com.interviewprep.dsa.dynamicProgramming;

public class LongestCommonSubstring {

    private static int lcSubString(String a, String b, int i, int j) {

        if (i == a.length() || j == b.length())
            return 0;
        if (a.charAt(i) == b.charAt(j)) {
            return 1 + lcSubString(a, b, i + 1, j + 1);
        } else {
            return Math.max(lcSubString(a, b, i + 1, j), lcSubString(a, b, i, j + 1));
        }

    }

    private static int lcsDP(String a, String b, int n, int m) {


        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

        String a = "GeekforGeeks";
        String b = "GeeksQuiz";

        int ans = lcSubString(a, b, 0, 0);
        System.out.println(ans);
        System.out.println(lcsDP(a, b, a.length(), b.length()));
    }
}
