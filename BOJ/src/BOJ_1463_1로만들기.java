import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1463_1로만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		int ans = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				if(cur == 1) {
					System.out.println(ans);
					return;
				}
				if(cur % 3 == 0)
					q.offer(cur / 3);
				if(cur % 2 == 0)
					q.offer(cur / 2);
				q.offer(cur-1);
			}
			ans++;
		}
		
	}
}
