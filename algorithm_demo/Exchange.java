import java.util.*;
/**
 * 找零钱练习
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
		//dp[i][j] 表示使用下标 0~i 的金币面值，去凑 aim 金额，有多少种方法
        int[][] dp = new int[n][aim+1];
		//初始化边界值
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int j=0; j<aim+1; j++){
            if(j%penny[0] == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }
		//计算 dp[n - 1][aim] 即为所求方法数
        for(int i=1; i<n; i++){
            for(int j=1; j<=aim; j++){
                if(penny[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-penny[i]];
                }
            }
        }
        return dp[n-1][aim];
    }
}