package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		List<Integer> num = new ArrayList<>();
		List<Character> op = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '-' || ch == '+') {
				op.add(ch);
			} else {
				StringBuilder tmp = new StringBuilder();
				while(i < str.length()) {
					ch = str.charAt(i);
					if(ch < '0' || ch > '9') break;
					tmp.append(ch);
					i++;
				}
				i--;
				num.add(Integer.parseInt(tmp.toString()));
			}
		} // 입력완료!!!
//		System.out.println(num);
//		System.out.println(op);
		
		int afterP[] = new int[num.size()];
		boolean[] visited = new boolean[num.size()];
		int idx = 0;
		
		for(int i = 0; i < op.size(); i++) {
			char tmp = op.get(i);
			if(tmp == '+') {
				if(i > 0 && op.get(i-1) == '+') {
					idx -= 1;
					afterP[idx] += num.get(i+1);
					visited[i+1] = true;
				}else {
					afterP[idx] = num.get(i)+num.get(i+1);					
					visited[i] = true; visited[i+1] = true;
				}
				idx++;
			} else if(tmp == '-' && idx == 0) {
				afterP[idx] = num.get(0);
				visited[0] = true;
				idx++;
			}
		}
		for(int i = 0; i < num.size(); i++) {
			System.out.println(visited[i]);
		}
		
		for(int i = 0; i < num.size(); i++) {
			if(!visited[i]) afterP[idx++] = num.get(i);
		}
		int ans = afterP[0];
		for(int i = 1; i < afterP.length; i++) {
			ans -= afterP[i];
		}
		for(int i = 0; i < afterP.length; i++) {
			System.out.println(afterP[i]);
		}
		System.out.println(ans);
	}
}
