import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_러시아국기같은깃발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			char[][] flag = new char[N][M];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					flag[i][j] = str.charAt(j);
				}
			} // 입력완료요
			
			for(int x = 1; x <= N-2; x++) {
				for(int y = 1; y <= N-x-1; y++) {
					// x가 white 줄 수, y가 blue 줄 수...
					int cnt = 0;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (i < x && flag[i][j] != 'W')
								cnt++;
							else if (i >= x && i < x + y && flag[i][j] != 'B')
								cnt++;
							else if (i >= x + y && flag[i][j] != 'R')
								cnt++;
						}
					}
					min = Math.min(min, cnt);
				}
			}


			sb.append("#" + t + " " + min + "\n");
		} // 테스트케이스

		System.out.println(sb);
	}
}
