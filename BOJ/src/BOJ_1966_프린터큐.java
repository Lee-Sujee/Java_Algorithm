import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Integer> print = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				print.add(Integer.parseInt(st.nextToken()));
			}
			
			sb.append(print.toArray()[N-M-1] + "\n");
		}
		
		System.out.println(sb);
	}
}
