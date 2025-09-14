import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
	static int[] arr1 = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] arr2 = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int N, start1, start2, dest1, dest2, min;
	static int[][] dist;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dist = new int[N][N]; // 이동거리를 저장할 이차원 배열
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
			start1 = Integer.parseInt(st.nextToken());
			start2 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			dest1 = Integer.parseInt(st.nextToken());
			dest2 = Integer.parseInt(st.nextToken());
			// 입력완료...
			
			bfs();
			System.out.println(min-1);
			
			
		} // 테스트케이스
		
	}
	
	static void bfs() {
		
		q.add(new int[] {start1, start2});
		dist[start1][start2]++;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int curr1 = tmp[0];
			int curr2 = tmp[1];
			if(curr1 == dest1 && curr2 == dest2) {
				if(min > dist[curr1][curr2]) min = dist[curr1][curr2];
			}
			
			for(int i = 0; i < 8; i++) {
				int next1 = curr1+arr1[i];
				int next2 = curr2+arr2[i];
				if(next1 < 0 || next1 >= N || next2 < 0 || next2 >= N) continue;
				if(dist[next1][next2] != 0 )continue;
				q.add(new int[] {next1, next2});
				dist[next1][next2] = dist[curr1][curr2] + 1;
			}
			
			
		}
		
	}
}
