import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int[][] paper;
	static int zero = 0, one = 0, mOne = 0; // 개수를 세기 위한 정수.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 종이 정보 저장 완료...
		
		cut(N, 0, 0);
		System.out.println(mOne);
		System.out.println(zero);
		System.out.println(one);
	}
	
	
	// 종이 자르기 메서드...
	// N은 종이의 크기를 의미!
	// idx1은 열, idx2는 행을 의미 -> paper[idx2][idx1]
	public static void cut(int N, int idx1, int idx2) {
		if(check(N, idx1, idx2)) return;
		if(N == 1) {
			return;
		}
		int n = N / 3; // 자르고 난 종이의 크기
	
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cut(n, idx1+(n*j), idx2+(n*i));				
			}
		}
	}
	
	// 체크해보자...
	public static boolean check(int N, int idx1, int idx2) {
		int dest = N*N;
		int cnt0 = 0, cnt1 = 0, cntm1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(paper[idx2+i][idx1+j] == 1) cnt1++;
				else if(paper[idx2+i][idx1+j] == 0) cnt0++;
				else if(paper[idx2+i][idx1+j] == -1) cntm1++;
			}
		}
		
		if(cnt0 == dest) {
			zero++;
			return true;
		}
		else if(cnt1 == dest) {
			one++;
			return true;
		}
		else if(cntm1 == dest) {
			mOne++;
			return true;
		}
		else return false;
	}
}


