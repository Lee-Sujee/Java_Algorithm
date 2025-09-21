import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1267_작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10 ; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			List<Integer>[] list = new List[V+1];
			for(int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			
			int[] hasP = new int[V+1]; // 루트 노드를 찾기 위해...
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				hasP[b]++;
			}
			System.out.print("#" + t + " ");
			Queue<Integer> q = new ArrayDeque<>();
			for(int i = 1; i <= V; i++) {
				if(hasP[i] == 0) q.offer(i);
			}
			while(!q.isEmpty()){
				int tmp = q.poll();
				
				System.out.print(tmp + " ");
				for(int i = 0; i < list[tmp].size(); i++) {
					int k = list[tmp].get(i);
					hasP[k]--;
					if(hasP[k] == 0) {
						q.offer(k);
					}
				}
				
			}
			System.out.println();
			
		}
		
	}
}
