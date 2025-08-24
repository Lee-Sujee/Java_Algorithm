import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_1986_지그재그숫자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			for(int i = 1; i <= N; i++) {
				if(i % 2 == 1)
					result += i;
				else
					result -= i;
			}
			
			bw.write("#" + t + " " + result + "\n");
		}
		
		
		br.close();
		bw.close();
	}
}
