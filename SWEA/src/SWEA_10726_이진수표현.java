import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726_이진수표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int t = 1; t <= T; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int mask = (1 << N) - 1;

			
			if((mask & M) == mask) sb.append("#" + t + " " + "ON\n");
			else sb.append("#" + t + " " + "OFF\n");
			
		} // 테스트케이스
		
		System.out.println(sb);
	}
}


