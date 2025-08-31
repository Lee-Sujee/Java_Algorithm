import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_7102_준홍이의카드놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+M+1];
			int max = 0;
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					arr[i+j]++;
					if(max < arr[i+j]) max = arr[i+j];
				}
			}
			
			List<Integer> list = new ArrayList<>();
			for(int i = 2; i <= N+M; i++) {
				if(arr[i] == max) list.add(i);
			}
			
			int[] result = new int[list.size()];
			for(int i = 0; i<list.size(); i++) {
				result[i] = list.get(i);
			}
			
			Arrays.sort(result);
			
			sb.append("#" + t + " ");
			for(int i = 0; i<list.size(); i++) {
				sb.append(result[i] + " ");
			}
			
			sb.append("\n");
		} // 테스트케이스
		
		System.out.println(sb);
	}
}
