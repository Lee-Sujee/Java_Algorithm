import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정{
	static class Meeting implements Comparable<Meeting>{
		int from;
		int to;
		int len;
		
		Meeting(){}
		Meeting(int from, int to) {
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Meeting m) {
			if(this.to == m.to) {
				return this.from - m.from;
			}
			return this.to - m.to;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			pq.offer(new Meeting(from, to));
		}
		int ans = 0; int idx = 0;
		for(int i = 0; i < N; i++) {
			Meeting m = pq.poll();
			
			if(idx <= m.from) {
				ans++;
				idx = m.to;
			}
			
		}
		
		System.out.println(ans);
	}

	
}
