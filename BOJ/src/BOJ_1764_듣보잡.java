import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			
			if(set.contains(str)) {
				result.add(str);
			}
		}
		
		String[] answer = new String[result.size()];
		result.toArray(answer);
		Arrays.sort(answer);
		sb.append(result.size() + "\n");
		for(int i = 0; i < result.size(); i++) {
			sb.append(answer[i] + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
