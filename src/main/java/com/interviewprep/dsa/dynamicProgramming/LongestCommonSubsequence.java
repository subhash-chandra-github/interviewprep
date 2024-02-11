package com.interviewprep.dsa.dynamicProgramming;



//recursive programm
public class LongestCommonSubsequence {

    int lcs (char[] a, char[] b, int m,int n)
    {


        if(m==0 || n ==0)
            return 0;
        if(a[m-1]==b[n-1]) {
            System.out.print(a[m-1]);
            return 1 + lcs(a, b, m - 1, n - 1);
        }
        else
            return Math.max(lcs(a,b,m-1,n),lcs(a,b,m,n-1));
    }

    void lcsDP(char a[], char b[], int m,int n)
    {

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j ==0)
                    dp[i][j] = 0;
                else if(a[i-1] == b [j-1])
                    dp[i][j] = 1+ dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

    System.out.println(dp[m][n]);

    }

    public static void main(String[] args) {

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

     //   System.out.println("Length of LCS is" + " " + lcs.lcs( X, Y, m, n ) );

        lcs.lcsDP( X, Y, m, n );
    }
}
