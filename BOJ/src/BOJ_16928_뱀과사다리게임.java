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
		int[] map = new int[101];
		q.offer(1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == 100) {
				System.out.println(map[100]);
				return;
			}
			move : for(int i = 1; i <= 6; i++) {
				int next = cur+i;
				if(next > 100) continue;
				if(map[next] != 0) continue;
				for(int j = 0; j < N; j++) {
					if(next == ladder[j][0]) {
						q.offer(ladder[j][1]);
						map[next] = map[cur]+1;
						continue move;
					}
				}
				for(int j = 0; j < M; j++) {
					if(next == snake[j][0]) {
						q.offer(snake[j][1]);
						map[next] = map[cur]+1;
						continue move;
					}
				}
				map[next] = map[cur]+1;
				q.offer(next);
			}
		}
		
		
	
	}
}
