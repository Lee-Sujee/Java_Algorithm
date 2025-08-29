import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1003_피보나치함수 {
	
	static int[] fiboA;
	static int x;
	static int cnt0, cnt1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			cnt0 = 0; cnt1 = 0;
			x = Integer.parseInt(br.readLine());
			fiboA = new int[x+1];
			fiboA[0] = 0;
			fibo(x);
			System.out.println(cnt0 + " " + cnt1);	
		}
	}
	
	static int fibo(int x) {
		if(x == 0) {
			cnt0++;
			return 0;
		}
		if(x == 1) {
			cnt1++;
			fiboA[x] = 1;
			return 1;
		}
		
		if(fiboA[x] != 0) {
			cnt0 += fiboA[x-1];
			cnt1 += fiboA[x];
			return fiboA[x];
		}
		else{
			int k = fibo(x-1) + fibo(x-2);
			fiboA[x] = k;
			return k;
		} 
		
	}
}
