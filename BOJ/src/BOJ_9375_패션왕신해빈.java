import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> closet = new HashMap<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String clothes = st.nextToken();
				String sort = st.nextToken();
				if(closet.containsKey(sort)) closet.replace(sort, closet.get(sort) + 1);
				else {
					closet.put(sort, 1);
				}
			}
			
			
			int[] dp = new int[N+1];
			Set<String> set = closet.keySet();
			int idx = 1;
			for(String s : set) {
				if(idx == 1) dp[idx] = closet.get(s);
				else if(idx == 2) dp[idx] = dp[idx-1] + closet.get(s) + dp[idx-1] * closet.get(s);
				else {
					dp[idx] = (dp[idx-1] * closet.get(s)) + dp[idx-1] +closet.get(s) ;
				}
		
				
				idx++;
			}
			sb.append(dp[idx-1] + "\n");
		} // 테스트케이스
		
		System.out.println(sb);
	}
}
