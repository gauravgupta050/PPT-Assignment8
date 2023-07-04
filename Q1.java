package Assignment8;

public class Q1 {
     public static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
    int ASCII_sum = 0;

    for (int i = 0; i < n; i++)
        ASCII_sum += s1.charAt(i);
    
    for (int i = 0; i < m; i++) 
        ASCII_sum += s2.charAt(i);

    int[][] dp = new int[n+1][m+1];

    int ans = ASCII_sum;
    for (int r = 0; r < n+1; r++) {
        for (int c = 0; c < m+1; c++) {
            if(r == 0 || c == 0)
                dp[r][c] = ASCII_sum;
            else if (s1.charAt(r-1) == s2.charAt(c-1)){
                dp[r][c] = dp[r-1][c-1] - 2*s1.charAt(r-1);
                ans = Math.min(ans, dp[r][c]);
            }else {
                dp[r][c] = Math.min(dp[r-1][c], dp[r][c-1]);
            }
        }
    }

    return ans;
}
public static void main(String[] args)
    {
        String s1 = "sea";
        String s2 = "eat";
        System.out.print(minimumDeleteSum(s1 , s2));
    } 
}
