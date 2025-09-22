import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

	static List<Integer>[] graph;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		graph = new List[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		} // 입력완료
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		int[] ans = new int[N+1];
		
		q.offer(1);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			visited[tmp] = true;
			
			for(int i = 0; i < graph[tmp].size(); i++) {
				int k = graph[tmp].get(i);
				if(visited[k]) continue;
				visited[k] = true;
				ans[k] = tmp;
				q.offer(k);
			}
		}
		
		for(int i = 2; i <= N; i++) {
			System.out.println(ans[i]);
		}
		
	
	}
	
	
}
