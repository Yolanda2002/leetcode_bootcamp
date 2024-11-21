package LeetcodeBootcamp.lecture8;

public class lc322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int j = 1; j < amount+1; j++){
            if(j >= coins[0]){
                dp[0][j] = dp[0][j-coins[0]]+1;
            }else{
                dp[0][j] = amount+1;
            }
        }
        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j < amount+1; j++){
                if(j >= coins[i]){
                    dp[i][j] = Integer.min(dp[i-1][j],dp[i][j-coins[i]]+1);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int x = dp[coins.length-1][amount];
        return x >= amount+1 ? -1 : x;
    }
}
