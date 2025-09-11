import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733_치즈도둑 {
	static int[][] cheese;
	static boolean[][] visited;
	static int N, max;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			cheese = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력완료
			
			max = Integer.MIN_VALUE;
			
			for(int k = 1; k <= 100; k++) {
				q = new LinkedList<>();
				visited = new boolean[N][N];
				bfs(k);				
			}
			
			
		} // 테스트케이스
	}
	
	static void bfs(int k) {
		for(int i = 0;  i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cheese[i][j] == k) visited[i][j] = true;
			}
		}
		
		
		
	}
	
}
