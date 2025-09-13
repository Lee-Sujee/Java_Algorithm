import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static int[] arr1 = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] arr2 = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Queue<int[]> q;
	static int N, click, min;
	static char[][] map;
	static boolean isZero;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			} // 입력완료!!

			min = Integer.MAX_VALUE;

			// bfs를 구현해보아요

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // 시작점 정하기
					int start1 = i;
					int start2 = j; // 시작지점이 (start1, start2)
					map[start1][start2] = 'c';
					click = 0;
					isZero = true;

					q = new LinkedList<>();

					q.offer(new int[] { start1, start2 });
					boolean isEnd = false; // 파핑파핑?

					boolean tmp = popping();
					while (tmp) {
						tmp = popping();
						
					}

					if (isEnd)
						continue;
					min = Math.min(min, click);

				}
			}

			System.out.println(min);
		}
	}

	static boolean popping() {
		click++;
		isZero = true;
		int[] tmp = q.poll();
		int isStar = 0; // 지뢰(별)인 것의 개수?

		for (int i = 0; i < 8; i++) {
			int next1 = tmp[0] + arr1[i];
			int next2 = tmp[1] + arr2[i];

			if (next1 < 0 || next1 >= N || next2 < 0 || next2 >= N)
				continue;

			if (map[next1][next2] == '*') {
				isStar++;
				isZero = false;
			}
			else if(map[next1][next2] == '.'){
				q.offer(new int[] {next1, next2});
				map[next1][next2] = 'c';
			}
		}

		return isZero;

	}
}
