import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				char ch = str.charAt(i);

				switch (ch) {
				case '(', '{', '[', '<':
					stack.push(ch);
					break;
				case ')':
					if (stack.peek() == '(')
						stack.pop();
					else
						stack.push(ch);
					break;
				case '>':
					if (stack.peek() == '<')
						stack.pop();
					else
						stack.push(ch);
					break;
				case ']':
					if (stack.peek() == '[')
						stack.pop();
					else
						stack.push(ch);
					break;
				case '}':
					if (stack.peek() == '{')
						stack.pop();
					else
						stack.push(ch);
					break;
				
				}
			}
			sb.append("#" + t + " ");
			if (stack.isEmpty()) {
				sb.append("1" + "\n");
			} else {
				sb.append("0" + "\n");
			}
		} // 테스트케이스
		
		System.out.println(sb);
	}
}