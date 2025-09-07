import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int[] price ;
	static int[] month;
	static int min;
	static int[] plan;
	static List<Integer> exist = new ArrayList<>(); // 이용권이 필요한 달만 저장...
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			price = new int[4];
			plan = new int[3];
			month = new int[12];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
				if(month[i]!=0)exist.add(i+1);
			}
			////////////////////////////입력완료////////////////////////////
			// 일단 1년권은 바로 계산가능하니 1년권을 min값으로 초기화하고 비교하겠다!
			min = price[3];
			System.out.println(exist);
		} // 테스트케이스
	}
	
	
	// 3달권을 사용하는 경우 체크
	public static void cal3() {
		
	}
	
	
	// 1일권 + 한달권 체크
	public static void cal(int idx) {

		System.out.println(Arrays.toString(plan));
	}
}
