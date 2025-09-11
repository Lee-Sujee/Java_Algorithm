import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<int[]> start = new ArrayList<>();
		int day = 1;

		int cnt = -1; // 토마토가 다 익는데 걸리는 일 수
		int[] arr1 = { -1, 0, 0, 1 };
		int[] arr2 = { 0, -1, 1, 0 };

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] tomato = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					start.add(new int[] { i, j });
				}
			}
		} // 입력완료...

		Queue<int[]> q = new LinkedList<>(); // 안에 인덱스값을 넣어 저장할 것!

		// 여기부터 그냥 안에서 bfs를 구현해볼게요...
		for (int i = 0; i < start.size(); i++) {
			q.add(new int[] {start.get(i)[0], start.get(i)[1]});
		}
		
		while (!q.isEmpty()) {

			int[] curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int next1 = curr[0] + arr1[i];
				int next2 = curr[1] + arr2[i];

				if (next1 < 0 || next1 >= N || next2 < 0 || next2 >= M)
					continue;
				if (tomato[next1][next2] == 0) {
					q.add(new int[] { next1, next2 });
					tomato[next1][next2] = tomato[curr[0]][curr[1]] + 1;
					if (tomato[next1][next2] > day)
						day = tomato[next1][next2];
					
				}
			}

		}

		// bfs 완료... 0이 있는게 있으면 -1 출력하고 없으면 카운트한 날짜를 출력한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(day-1);

	}
}