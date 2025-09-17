import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N, K;
	static Queue<Integer> q = new LinkedList<>();
	static boolean[] visited;
	static int[] dist;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		dist = new int[100001];
		
		bfs();
		System.out.println(dist[K]);
		
	}
	
	static void bfs() {
		q.add(N);
		visited[N] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
				
			if(curr == K) return;
			if(curr - 1 >= 0 && !visited[curr-1]) {
				q.add(curr - 1);
				visited[curr -1] = true;
				dist[curr - 1] = dist[curr]+1;				
			}
			if(curr + 1 < visited.length && !visited[curr+1]) {
				q.add(curr + 1);
				visited[curr+1] = true;
				dist[curr + 1] = dist[curr]+1;				
			}
			if(curr * 2 < visited.length && !visited[curr*2]) {
				q.add(curr * 2);
				visited[curr*2] = true;
				dist[curr * 2] = dist[curr]+1;				
			}
			
		}
		
	}
}
