import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1914_하노이탑 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		BigInteger ans = BigInteger.valueOf(2).pow(N);
		ans = ans.subtract(BigInteger.valueOf(1));
		System.out.println(ans);
		if(N <= 20) {
			hanoi(N, 1, 2, 3);
		}
		
	}
	
	
	static void hanoi(int N, int from, int by, int to) {
		if(N == 0) return;
		
		hanoi(N-1, from, to, by);
		System.out.println(from + " " + to);
		hanoi(N-1, by, from, to);
		
		
	}
}
