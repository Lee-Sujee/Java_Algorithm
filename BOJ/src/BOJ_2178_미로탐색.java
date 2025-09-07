
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	static int min = Integer.MAX_VALUE;
	static int[][] maze;
	static boolean[][] visited;
	static int N, M;
	static int[] arr1 = {-1, 0, 0, 1};
	static int[] arr2 = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		} // 입력완료!
		
		dfs(0, 0, 1); // 시작점 1카운트로 시작.
		System.out.println(min);
	}
	
	public static void dfs(int idx1, int idx2, int cnt) {
		if(idx1 == N-1 && idx2 == M-1) {
			if(cnt < min) min = cnt;
			return;
		}
		if(visited[idx1][idx2]) return;
		visited[idx1][idx2] = true;
		int i1 = 0, i2 = 0, x = 0;
		for(int i = 0; i < 4; i++) {
			i1 = idx1+arr1[i]; 
			i2 = idx2+arr2[i]; 
			if(i1 < 0 || i1 >= N || i2 < 0 || i2 >= M) continue;
			if(maze[i1][i2] == 0) continue;
			if(!visited[i1][i2]) {
				x = i;
				cnt++;
				dfs(i1, i2, cnt);
				cnt--;
				visited[idx1][idx2] = false;
			}
		}

	}
}
