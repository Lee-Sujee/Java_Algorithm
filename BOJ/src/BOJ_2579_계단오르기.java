import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {
	static int N;
	static int[] stairs;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		stairs = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		} // 입력완료

		int[] dp = new int[N+1];
		
		dp[1] = stairs[1];
		if(N>=2)dp[2] = stairs[1]+stairs[2];
		if(N>=3)dp[3] = Math.max(stairs[1] + stairs[3], stairs[2]+stairs[3]);
		if(N>=4) {
			
			for(int i = 4; i <= N; i++) {
				dp[i] = Math.max(dp[i-2]+stairs[i], dp[i-3] + stairs[i-1]+stairs[i]);
			}
		}
		
		System.out.println(dp[N]);
	}

	
}
