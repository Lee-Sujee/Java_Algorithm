import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {
	static int[] Kyu;
	static int[] In;
	static boolean[] visited = new boolean[9]; // -> 인영이 카드 배치에 사용!
	static int[] tmp = new int[9];
	static int win, lose;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			win = 0; lose = 0;
			Kyu = new int[9];
			In = new int[9];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				Kyu[i] = Integer.parseInt(st.nextToken());
			} // 입력완료..

			int idx = 0;
			for (int j = 1; j <= 18; j++) {
				int cnt = 0;
				for (int i = 0; i < 9; i++) {
					if (Kyu[i] == j) {
						cnt++;
						break;
					}
				}
				if (cnt == 0) {
					In[idx] = j;
					if (idx < 8)
						idx++;
				}
			} // 인영이 카드 배열 완료
			
			perm(0);
			System.out.println("#" + t + " " + win + " " + lose);
			
		} // 테케

	} // 메인

	public static void perm(int idx) {
		if(idx == 9) {
			game();
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			tmp[idx] = In[i];
			perm(idx+1);
			visited[i] = false;
		}
	}
	
	public static void game() {
		// tmp배열과 Kyu 배열을 돌면서 이기는지 지는지 확인해보자...
		int K = 0; int I = 0; // 규영이와 인영이의 점수
		
		for(int i = 0; i < 9; i++) {
			if(Kyu[i] > tmp[i]) K += (Kyu[i]+tmp[i]);
			else if(Kyu[i] < tmp[i]) I += (Kyu[i]+tmp[i]);
		}
		
		if(K > I) win++;
		if(K < I) lose++;
	}
}


