import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N, M, V;
	static List<Integer>[] graph;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		// 리스트 내의 정점들을 오름차순으로 정리했다...
		for (int i = 0; i <= N; i++) {
			graph[i].sort(null);
			;
		}
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visited = new boolean[N + 1]; // 방문여부 배열 초기화...
		bfs();
	}

	public static void dfs(int idx) {

		if (visited[idx]) {
			return;
		}
		visited[idx] = true;
		System.out.print(idx + " ");

		for (int i = 0; i < graph[idx].size(); i++) {
			int tmp = graph[idx].get(i);
			dfs(tmp);
		}
	}

	public static void bfs() {
		int curr = V;
		q.add(curr);
		visited[curr] = true;
		while(!q.isEmpty()) {
			curr = q.poll();
			System.out.print(curr + " ");
			for(int next : graph[curr]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
