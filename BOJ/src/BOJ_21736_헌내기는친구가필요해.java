import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21736_헌내기는친구가필요해 {
	static int[] arr1 = {-1, 0, 0, 1};
	static int[] arr2 = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int s1 = -1, s2 = -1;
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') {
					s1 = i; s2 = j;
				}
			}
		} // 입력완료
		
		int cnt = 0;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {s1, s2});
		while(!q.isEmpty()) {

			for(int k = 0; k < q.size(); k++) {
				int[] tmp = q.poll();
				int c1 = tmp[0];
				int c2 = tmp[1];
				visited[c1][c2] = true;
				
				for(int i = 0; i < 4; i++) {
					int n1 = c1 + arr1[i];
					int n2 = c2 + arr2[i];
					
					if(n1 < 0 || n1 >= N || n2 < 0 || n2 >= M) continue;
					if(map[n1][n2] == 'X') continue;
					if(visited[n1][n2]) continue;
					q.offer(new int[] {n1, n2});
					visited[n1][n2] = true;
					if(map[n1][n2] == 'P') cnt++;
				}
				
			}
			
		}
		if(cnt == 0) {
			System.out.println("TT");
		}
		else {
			System.out.println(cnt);
		}
		
	}
}
