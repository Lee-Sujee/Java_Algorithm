import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2806_NQueen {
	static int ans;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			queen(0);
			System.out.println("#" + t + " " + ans);

		} // testcase
	}

	static void queen(int row) {
		if (row == N) {
			ans++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (check(row, c)) {
				arr[row][c] = 1;
				queen(row + 1);
				arr[row][c] = 0;
			}

		}
	}

	static boolean check(int r, int c) {

		for (int i = 0; i < r; i++) { // 같은 열에 있는지를 체크
			if (arr[i][c] == 1) return false;
		}
		// 대각체크...
		for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == 1) return false;
		}
		// 대각체크...
		for (int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
			if (arr[i][j] == 1) return false;
		}
		return true;
	}
}
