import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5521_상원이의생일파티 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int cnt = 0; // 초대할 친구 수 카운트
			boolean[] invite = new boolean[N+1]; // 방문했는지? -> 초대했는지!
			List<Integer>[] friend = new ArrayList[N+1]; // 0은 사용하지 않아요..
			for(int i = 0; i <= N; i++) {
				friend[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) { // 친구관계(간선) 입력
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				
				friend[a].add(b);
				friend[b].add(a);
			} // 친구관계 그래프 저장 완료!
			
			List<Integer> list = new ArrayList();
			invite[1] = true; // 자기자신은 먼저 방문한걸로 치자!
			for(int i = 0; i < friend[1].size(); i++) {
				list.add(friend[1].get(i));
				invite[friend[1].get(i)] = true;
				cnt++;
			}
			// 1번 상원이까지는 확인했다!
			for(int i = 0; i < list.size(); i++) {
				int tmp = list.get(i);
				for(int j = 0; j < friend[tmp].size(); j++) {
					if(invite[friend[tmp].get(j)]) continue;
					invite[friend[tmp].get(j)] = true;
					cnt++;
				}
			}
			sb.append("#" + t + " " + cnt + "\n");
		} // 테케...
		
		System.out.println(sb);
		
	}
}
