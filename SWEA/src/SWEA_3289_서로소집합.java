import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); // 원소의 최댓값
			int m = Integer.parseInt(st.nextToken()); // 주어진 연산의 개수
			p = new int[n+1];
			for(int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op == 0) {
					union(a, b);
				}
				else if(op == 1) {
					System.out.print(isExist(a,b));
				}
				
			}
			
			System.out.println();
		} // 테스트케이스
		
	}
	
	static int check(int a) {
		if(p[a] == a) return a;
		
		return p[a] = check(p[a]);
	}
	
	static void union(int a, int b) {
		int ahead = check(a);
		int bhead = check(b);
		if(ahead != bhead) p[ahead] = bhead;
	}
	 
	static int isExist(int a, int b) {
		int ahead = check(a);
		int bhead = check(b);
		if(ahead == bhead) return 1;
		else return 0;
	}
	
}
