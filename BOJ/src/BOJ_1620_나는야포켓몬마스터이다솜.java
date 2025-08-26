import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 포켓몬의 수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야하는 문제의 수
		
		Map<Integer, String> index1 = new HashMap<>();
		Map<String, Integer> index2 = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			index1.put(i+1, str);
			index2.put(str, i+1);
		}
		
		for(int i = 0; i < M; i++) {
			String quiz = br.readLine();
			if(isNumber(quiz)) {
				sb.append(index1.get(Integer.parseInt(quiz)) + "\n");
			} else {
				sb.append(index2.get(quiz) + "\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	static boolean isNumber(String str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;
		}
		return true;
	}
}
