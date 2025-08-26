import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	public static List<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		set = new ArrayList<>();
		StringBuilder sb = new StringBuilder();	
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken();
			int x;
			
			switch(cmd) {
			case "add" :
				x = Integer.parseInt(st.nextToken());
				add(x);
				break;
			case "remove" :
				x = Integer.parseInt(st.nextToken());
				remove(x);
				break;
			case "check" :
				x = Integer.parseInt(st.nextToken());
				sb.append(check(x));
				sb.append("\n");
				break;
			case "all" :
				all();
				break;
			case "toggle" :
				x = Integer.parseInt(st.nextToken());
				toggle(x);
				break;
			case "empty" :
				empty();
				break;
			}	
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void add(int x) {
		if(isExist(x)) return;
		else set.add(x);
	}
	
	public static void remove(int x) {
		if(!isExist(x)) return;
		else set.remove(Integer.valueOf(x));
	}
	
	public static String check(int x) {
		if(isExist(x) == true) {
			return "1";
		} else {
			return "0";
		}
	}

	public static void toggle(int x) {
		if(isExist(x)) {
			set.remove(Integer.valueOf(x));
		} else {
			set.add(x);
		}
	}
	public static void all() {
		set.clear();
		for(int i = 1; i <= 20; i++) {
			set.add(i);
		}
	}
	
	public static void empty() {
		set.clear();
	}
	
	public static boolean isExist(int x) {
		for(int i = 0; i < set.size(); i++) {
			if(set.get(i).equals(x)) return true;
		}
		return false;
	}
}
