import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] money = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] ans = new int[8];
			
			for(int i = 0; i < 8; i++) {
				while(N - money[i] >= 0) {
					ans[i]++;
					N -= money[i];
				}
			}
			
			System.out.println("#" + t);
			for(int k : ans) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}
}
