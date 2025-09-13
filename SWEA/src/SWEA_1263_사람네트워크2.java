import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
	public static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			List<int[]> list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) {
						list.add(new int[] {i, j}); // i -> j 간선정보 저장
					}
				}
			} // 입력완료..

			int[] D = new int[N]; // 가중치를 저장할 배열
			
			int min = INF; // 한 그래프에서의 최소 이동거리를 찾아 저장
			
			// 시작노드를 바꿔주면서 최소값을 찾겠다..
			for(int i = 0; i < N; i++) {
				Arrays.fill(D, INF);
				
				D[i] = 0;
				for(int k = 0; k < N-1; k++) {
					boolean isRe = false; // 최종 갱신 완료?
				for(int j = 0; j < list.size(); j++) {
					int u = list.get(j)[0];
					int v = list.get(j)[1]; // 간선은 지금 u -> v 형태!
					
					if(D[u] != INF && D[v] > D[u] + 1) {
						D[v] = D[u] + 1;
						isRe = true;
					}
					
				}
				if (!isRe)
					break; // 갱신이 완전히 끝! -> 종료시킨다.
				}
				
				int sum = 0;
				for(int d : D) {
					sum += d;
				}
				
				min = Math.min(sum, min);
			}
			System.out.print("#" + t + " ");
			System.out.println(min);
		} // 테스트케이스!		
	}
}
