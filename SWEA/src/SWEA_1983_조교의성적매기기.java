import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1983_조교의성적매기기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			double[] score = new double[N];
			double dest = 0.0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				// 점수를 아예 총점으로 계산해서 배열에 저장한다!
				score[i] = 0.35*a + 0.45*b + 0.2*c;
				// 찾고자하는 학생의 총정을 dest 변수에 저장해둔다.
				if(i == K-1) dest = score[i];
			}
			
			// score 배열을 오름차순으로 정리하고
			// 찾고자하는 학생이 오름차순으로 나열했을때 어디에 위치하는지 인덱스값을 찾는다.
			Arrays.sort(score);
			int idx = -1;
			for(int i = 0; i < N; i++) {
				if(dest == score[i]) {
					idx = i;
					break;
				}
			}
			// 앞에서부터 차례로 N/10개씩 끊어서 묶어보았다.
			int result = idx / (N / 10);
			String answer = null;
			// 끊어서 묶은 곳 중 찾고자 하는 학생이 어디에 위치하는지를 찾고
			// 그 위치가 어느 평점인지를 찾는다.
			switch(result) {
			case 0: answer = "D0"; break;
			case 1: answer = "C-"; break;
			case 2: answer = "C0"; break;
			case 3: answer = "C+"; break;
			case 4: answer = "B-"; break;
			case 5: answer = "B0"; break;
			case 6: answer = "B+"; break;
			case 7: answer = "A-"; break;
			case 8: answer = "A0"; break;
			case 9: answer = "A+"; break;
			
			}
			bw.write("#" + t + " " + answer + "\n");
		} // 테스트케이스

		br.close();
		bw.close();
	}
}
