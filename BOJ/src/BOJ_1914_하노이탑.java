import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1914_하노이탑 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N <= 20)
			hanoi(N, 0, 1, 2);
		else {
			BigInteger ans = BigInteger.TWO.pow(N);
			ans = ans.subtract(BigInteger.ONE);
			System.out.println(ans);
		
		}
		
	}
	
	
	static void hanoi(int N, int from, int by, int to) {
		if(N == 0) return;
		
		hanoi(N-1, from, to, by);
		System.out.println(from + " " + to);
		hanoi(N-1, by, from, to);
		
		
	}
}
