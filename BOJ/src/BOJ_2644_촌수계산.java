import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		st = new StringTokenizer(br.readLine());
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
	
		int ans = -1;
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		q.offer(d1);
		while(!q.isEmpty()) {
			int size = q.size();
			ans++;
			for(int k = 0; k < size; k++) {
				int cur = q.poll();
				if(cur == d2) {
					System.out.println(ans);
					return;
				}
				visited[cur] = true;
				
				
				for(int i = 0; i < list[cur].size(); i++) {
					int x = list[cur].get(i);
					if(visited[x]) continue;
					q.offer(x);
					visited[x] = true;
				}
				
			}
			
		}
	
		System.out.println(-1);
	
	
	
	}
}
