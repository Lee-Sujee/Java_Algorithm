import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
	static int N,L, maxS;
	static int[][] ingredients;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			ingredients = new int[N][2]; // 차례로 맛 점수 - 칼로리
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				ingredients[i][0] = Integer.parseInt(st.nextToken()); 
				ingredients[i][1] = Integer.parseInt(st.nextToken()); 
				
			} // 입력완료!!
			
			maxS = 0;
			
			comb(0, 0, 0);
			
			
			bw.write("#" + t + " " + maxS + "\n");
			bw.flush();
		}

		br.close();
		bw.close();
	}
	
	public static void comb(int idx, int scr, int cal) {
		if(cal > L) return; // 제한 칼로리를 넘으면 그냥 종료한다.
		// 모든 조합을 확인했을 경우 maxS를 업데이트 하고 종료한다.
		else if(idx == N) {
			maxS = Math.max(maxS, scr);
			return;
		}
		// 재료선택 o ->점수와 칼로리를 업데이트하고 다음으로 넘어간다.
		comb(idx + 1, scr + ingredients[idx][0], cal + ingredients[idx][1]);
		// 재료선택 x -> 점수와 칼로리를 그대로 두고 index값만 증가시킨다.
		comb(idx + 1, scr, cal);
		
	}
}
