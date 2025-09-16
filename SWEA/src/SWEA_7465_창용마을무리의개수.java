import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	static int[] p;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int M = Integer.parseInt(st.nextToken()); // 관계의 수
			
			p = new int[N+1]; // 기본 루트 초기화...
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);				
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				find(i);
				set.add(p[i]);
			}
			System.out.println(set.size());
		} // 테스트케이스
	}
	
	static int find(int a) {
		if(p[a] == a) return a;
		
		return p[a] = find(p[a]);
	}
	
	
	static void union(int a, int b) {
		int ahead = find(a);
		int bhead = find(b);
		if(ahead==bhead) return;
		p[ahead] = bhead;
		
	}
}
