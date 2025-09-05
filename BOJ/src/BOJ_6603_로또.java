import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
	static int[] arr, ans;
	static int R = 6;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			if (x == 0)
				break;

			arr = new int[x];
			ans = new int[R];
			visited = new boolean[x];
			for (int i = 0; i < x; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			lotto(0, 0);
			System.out.println();

		}
	}

	public static void lotto(int idx, int start) {

		if (idx == R) {
//			System.out.println(Arrays.toString(ans));
			for(int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			
			return;
		}
		else if(start == arr.length) return;
		if (visited[start])
			return;
		ans[idx] = arr[start];
		visited[start] = true;
		lotto(idx + 1, start + 1);
		lotto(idx, start + 1);

		visited[start] = false;

	}
}
