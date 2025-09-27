import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_2Xn타일링2 {
	static int[] dp;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];

		for(int i = 1; i <= N; i++) {
			
			if(i > 2)
				dp[i] = dp[i-1] + dp[i-2] * 2;
			else if(i == 1)
				dp[i] = 1;
			else if(i == 2)
				dp[i] = 3;
			dp[i] %= 10007;
		}
		System.out.println(dp[N]);
	}
}
