import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2407_조합 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger ans = BigInteger.ONE;
		if(m > n/2) m = n-m;
		for(int i = 0; i < m; i++) {
			ans = ans.multiply(BigInteger.valueOf(n-i));
		}
		for(int i = 1; i <= m; i++) {
			ans = ans.divide(BigInteger.valueOf(i));
			
		}
		System.out.println(ans);
	}
}
