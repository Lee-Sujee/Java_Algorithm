import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		} // 입력완료..
		
		
		Arrays.sort(P);
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			result += P[i] * (N-i);
		}
		
		System.out.println(result);
		br.close();
	}
}
