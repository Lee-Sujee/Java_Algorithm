import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리 {
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = (str.charAt(j)) - '0';
			}
		}// 입력완료
		
		compress(N, 0, 0);
	}
	

	public static void compress(int N, int idx1, int idx2) {
		if(check(N, idx1, idx2)) return;
		if(N==1) return;
		
		int n = N / 2;
		System.out.print('(');
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				compress(n, idx1 + (n*i), idx2 + (n*j));
			}
		}
		System.out.print(')');
	}
	
	public static boolean check(int N, int idx1, int idx2) {
		int dest = N*N;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				cnt += arr[idx1 + i][idx2 + j];
			}
		}
		
		if(cnt == dest) {
			System.out.print(1);
			return true;
		}
		else if(cnt == 0) {
			System.out.print(0);
			return true;
		}
		else return false;
		
	}
}
