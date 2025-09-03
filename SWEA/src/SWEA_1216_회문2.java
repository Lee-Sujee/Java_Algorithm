import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1216_회문2 {
	static boolean isP;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			isP = false;
			
			arr = new char[100][100];
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				
				arr[i] = str.toCharArray();
			} // 입력완료
			
			int result = 1;
			for(int len = 100; len > 1; len--) { // 회문 탐색 길이
				for(int i = 0; i < 100; i++) {
					for(int j = 0; j <= 100-len; j++) {
						palindrome(i, j, i, j+len-1);
						palindrome(j, i, j+len-1, i);
						if(isP) {
							result = len;
							break;
						}
					}if(isP) break;
				}if(isP) break;
				
				
			}

			System.out.println(result);
			
		}// 테케
	
	
	}
	
	public static void palindrome(int x1, int y1, int x2, int y2) {
		if(x1 == x2) { // 가로회문
			for(int i = 0; i < y2-y1; i++) {
				if(arr[x1][y1 + i] != arr[x2][y2-i]) {
					return;
				}
			}
		}
		else if(y1 == y2) {
			for(int i = 0; i < x2-x1; i++) {
				if(arr[x1+i][y1] != arr[x2-i][y2]) {
					return;
				}
			}
		}
		isP = true;
	}
}