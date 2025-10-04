import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사다리 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		int[][] ladder = new int[N][2];
		int[][] snake = new int[M][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ladder[i][0] = Integer.parseInt(st.nextToken());
			ladder[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			snake[i][0] = Integer.parseInt(st.nextToken());
			snake[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		int ans = -1;
		move : while(!q.isEmpty()) {
			ans++;
			int cur = q.poll(); // 현재 위치...
			if(cur == 100) {
				System.out.println(ans);
			}
			for(int a = 6; a > 0; a--) {
				for(int b = 0; b < N; b++) {
					if(cur + a == ladder[b][0] && cur+a <= 100) {
						q.offer(ladder[b][1]);
						continue move;
					}
				}
			}
			
			dice : for(int a = 6; a > 0; a--) {
				for(int b = 0; b < M; b++) {
					if(cur + a == snake[b][0]) {
						continue dice;
					}
				}
				if(cur+a <= 100) {
					q.offer(cur +a);
					break;
				}
			}
			
		}
		
		
	}
}
