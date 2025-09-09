import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static Queue<int[]> land = new LinkedList<>();
	static int[] arr1 = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] arr2 = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int cnt = 1;
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		
		while(!str.equals("0 0")) {
			cnt = 0;
			st = new StringTokenizer(str, " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 0) visited[i][j] = true;
					if(map[i][j] == 1) land.add(new int[] {i, j});
				}
			}
			str = br.readLine();
			// 입력해써요
			
			bfs();
			System.out.println(cnt);
		} 

		
	}
	
	static void bfs() {
		if(land.isEmpty()) return;
		int[] tmp = land.poll();
		int curr1 = tmp[0];
		int curr2 = tmp[1];
		while(!land.isEmpty() || !visited[curr1][curr2]) {
			q.add(new int[] {curr1, curr2});
			while(!q.isEmpty()) {
				tmp = q.poll();
				curr1 = tmp[0];
				curr2 = tmp[1];
				if(visited[curr1][curr2]) continue;
				visited[curr1][curr2] = true;
				
				for(int i = 0; i < 8; i++) {
					int next1 = curr1 + arr1[i];
					int next2 = curr2 + arr2[i];
					
					// 범위 벗어나면 안되겠지...
					if(next1 < 0 || next1 >= h || next2 < 0 || next2 >= w) continue;
					// 방문했으면 안되겠지...
					if(visited[next1][next2]) continue;
					q.add(new int[] {next1, next2});
				}
			}
			cnt++;
			while(visited[curr1][curr2] && !land.isEmpty()) {
				tmp = land.poll();
				curr1 = tmp[0];
				curr2 = tmp[1];
			}
		}
	}
}
