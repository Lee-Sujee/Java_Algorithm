import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] arr1 = { -1, 0, 0, 1 };
		int[] arr2 = { 0, -1, 1, 0 };

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 가로길이
			int N = Integer.parseInt(st.nextToken()); // 세로길이
			int K = Integer.parseInt(st.nextToken()); // 배추 개수

			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			List<int[]> list = new ArrayList<>();

			int cnt = 0;
			;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[b][a] = 1;
				list.add(new int[] { b, a });
			} // 입력끝!

			Queue<int[]> q = new ArrayDeque<>();

			for (int[] L : list) {
				int i = L[0];
				int j = L[1];
				if (visited[i][j] || map[i][j] == 0)
					continue;

				q.offer(new int[] { i, j });
				visited[i][j] = true;

				while (!q.isEmpty()) {
					int[] tmp = q.poll();
					int c1 = tmp[0];
					int c2 = tmp[1];

					visited[c1][c2] = true;

					for (int k = 0; k < 4; k++) {
						int n1 = c1 + arr1[k];
						int n2 = c2 + arr2[k];

						if (n1 < 0 || n1 >= N || n2 < 0 || n2 >= M || visited[n1][n2])
							continue;

						if (map[n1][n2] == 1) {
							visited[n1][n2] = true;
							q.offer(new int[] { n1, n2 });
					
						}
					}
				}
				cnt++;

			}

			System.out.println(cnt);
		} // 테스트케이스
	}
}
