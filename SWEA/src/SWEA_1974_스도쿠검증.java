import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			
			int[][] puzzle = new int[9][9];
			
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력완료!
			
			int result = 1;
			// 가로탐색
			for(int i = 0; i < 9; i++) {
				int[] arr = new int[10];
				for(int j = 0; j < 9; j++) {
					arr[puzzle[i][j]]++;
				}
				for(int j = 0; j < 10; j++) {
					if(arr[j] > 1) {
						result = 0;
						break;
					}
				}
			}
			//세로탐색
			for(int j = 0; j < 9; j++) {
				int[] arr = new int[10];
				for(int i = 0; i < 9; i++) {
					arr[puzzle[i][j]]++;
				}
				for(int i = 0; i < 10; i++) {
					if(arr[i] > 1) {
						result = 0;
						break;
					}
				}
			}
			// 정사각형 탐색
			int idx1 = 0, idx2 = 0;
			for(int i = 0; i < 9; i++) {
				int[] arr = new int[10];
				for(int a = 0; a < 3; a++) {
					for(int b = 0; b < 3; b++) {
						arr[puzzle[idx1+a][idx2+b]]++;
					}
				}
				for(int x = 0; x < 10; x++) {
					if(arr[x] > 1) {
						result = 0;
						break;
					}
				}
				idx1 += 3; idx2 += 3;
				if(idx1 >= 9) idx1 -= 9;
				if(idx2 >= 9) idx2 -= 9;
			}
			
			// 출력!
			bw.write("#" + t + " " + result + "\n");
			
			bw.flush();
		} // 테스트케이스
		br.close();
		bw.close();
	}
}
