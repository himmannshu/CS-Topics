import java.util.*;
public class DiceCombinations {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(numWays(n));
	}

	private static int numWays(int n){
		int mod = 1000000007;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for(int i = 1; i<=n; i++){
			for(int j = 1; j<=6 && i-j>=0; j++){
				dp[i] = (dp[i] + dp[i - j])% mod;
			}
		}
		//System.out.println(Arrays.toString(dp));
		return dp[n];
	}

}