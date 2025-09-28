import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			int B = Integer.parseInt(st.nextToken());
			
			Queue<String[]> q = new ArrayDeque<>();
			boolean[] visited = new boolean[10000];
			q.offer(new String[] {A, null});
			visited[Integer.parseInt(A)] = true;
			while(!q.isEmpty()) {
				String[] tmp = q.poll();
				int c = Integer.parseInt(tmp[0]);
				String path;
				if(tmp[1] == null) path = "";
				else path = tmp[1];
				
				if(c == B) {
					System.out.println(path);
					break;
				}
				
				int n = c * 2;
				if(n > 9999) n %= 10000;
				if(!visited[n]) {
					visited[n] = true;
					q.offer(new String[] {String.valueOf(n), path+"D"});
				}
				if(c == 0) n = 9999;
				else n = c - 1;					
				if(!visited[n]) {
					visited[n] = true;
					q.offer(new String[] {String.valueOf(n), path+"S"});
				}
				n = (c % 1000) * 10 + (c / 1000);
				if(!visited[n]) {
					visited[n] = true;
					q.offer(new String[] {String.valueOf(n), path+"L"});
				}
				n = (c % 10) * 1000 + (c / 10);
				if(!visited[n]) {
					visited[n] = true;
					q.offer(new String[] {String.valueOf(n), path+"R"});
				}
			}			
		} // 테스트케이스
	}
}
