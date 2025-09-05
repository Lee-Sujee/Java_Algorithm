import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int[] price ;
	static int[] month;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			price = new int[4];
			month = new int[12];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			////////////////////////////입력완료////////////////////////////
			min = price[3];
			System.out.println(min);
			
		} // 테스트케이스
	}
	
	public static void cal() {
		
	}
}
