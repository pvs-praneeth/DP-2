// Time Complexity : O(amount*coins)
// Space Complexity : O(amount*coins)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea here is to keep track of all the possible options that we come across in the recursive stack.
// We follow a binary approach to find the valid change required for the given amount.
// Every time we have an option wether to choose the coin or not.
//      If we are able to make the amount with the chosen coin then we return 1.
//      If we are not able to make the amount with the chose coin then we return 0.
// We sum all the options that are available for a given change and amount. 
// Finally return the number of options that we obtained.

import java.util.Arrays;

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        
        if(coins == null || coins.length == 0) return 0;
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        // Filling the first row to infinity
        Arrays.fill(dp[0], 0);
        
        // Filling the first column to 0
        for(int i=0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
    }
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,3,4}));
        System.out.println(change(3, new int[]{2}));
        System.out.println(change(20, new int[]{10, 20}));
    }
}