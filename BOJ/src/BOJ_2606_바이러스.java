import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int N, M;
	static List<Integer>[] graph;
	static int cnt = 0;
	static Queue<Integer> q = new LinkedList<>();;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 총 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 연결 쌍 개수
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		
		// 리스트 초기화
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		 for(int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine(), " ");
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 graph[a].add(b);
			 graph[b].add(a);
		 } // 입력완료...
		 
		 
		 bfs();
		 System.out.println(cnt);
		 
		
	}
	
	static void bfs() {
		// 시작은 항상 1번에서부터...
		int curr = 1;
		q.add(curr);
		while(!q.isEmpty()) {
			curr = q.poll();
			visited[curr] = true;
			
			for(int i = 0; i < graph[curr].size(); i++) {
				if(visited[graph[curr].get(i)]) continue;
				visited[graph[curr].get(i)] = true;
				cnt++;
				q.add(graph[curr].get(i));
			}
		}
	}
}
