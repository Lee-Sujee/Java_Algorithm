import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int[] price; // 1일권, 1달권, 3달권, 1년권 가격
	static int[] plan; // 달별 이용계획
	static int min; // 최소 가격

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			min = 0;
			price = new int[4];
			plan = new int[12];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//////////////////// 입력완료! ////////////////////////
			min = price[3]; // 최솟값을 먼저 1년권으로 지정해두고 비교 시작!

			minCost(0, 0);
			System.out.println("#" + t + " " + min);

		} // 테스트케이스

	}

	public static void minCost(int mon, int cost) {
		// 12월까지 전부 체크했으면 종료!
		if (mon >= 12) {
			if (min > cost)
				min = cost;
			return;
		}

		// 3달권 이용
		minCost(mon + 3, cost + price[2]);
		// 1달권 이용
		minCost(mon + 1, cost + price[1]);
		// 1일권 이용
		minCost(mon + 1, cost + (price[0] * plan[mon]));

	}
}
