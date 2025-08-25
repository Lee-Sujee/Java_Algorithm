// silver2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		int cnt = 0;
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
 
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i = 1; i <= N ; i++) {
			
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}

		System.out.println(cnt);
		
		
		br.close();
		bw.close();
	}
	
	public static void dfs(int i) {
		if(visited[i] == true) return;
		
		visited[i] = true;
//		for(int x = 0; x < graph.get(i).size(); x++) {
//			if(!visited[graph.get(i).get(x)]) {
//				dfs(graph.get(i).get(x));
//			}
//		}
		for (int neighbor : graph.get(i)) {
			if (!visited[neighbor]) {
				dfs(neighbor);
			}
		}
	}
}	