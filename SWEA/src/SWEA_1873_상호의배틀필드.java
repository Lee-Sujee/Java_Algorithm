import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	static char[][] map;
	static int W, H, i1, i2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			i1 = -1;
			i2 = -1;
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						i1 = i;
						i2 = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());

			char[] op = new char[N];
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				op[i] = str.charAt(i);
			} // 일단 입력은 완료...

			for (char c : op) {
				
				switch (c) {
				case 'U':
					up(i1, i2);
					break;
				case 'D':
					down(i1, i2);
					break;
				case 'L':
					left(i1, i2);
					break;
				case 'R':
					right(i1, i2);
					break;
				case 'S':
					shoot(i1, i2);
					break;

				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} // 테스트케이스

	}

	static boolean up(int idx1, int idx2) {

		int n1 = idx1 - 1;
		int n2 = idx2;

		if (n1 < 0 || n1 >= H || n2 < 0 || n2 >= W || map[n1][n2] != '.') {
			i1 = idx1;
			i2 = idx2;
			map[i1][i2] = '^';
			return false;
		} else {
			map[idx1][idx2] = '.';
			map[n1][n2] = '^';
			i1 = n1;
			i2 = n2;
			return true;
		}
	}

	static boolean down(int idx1, int idx2) {

		int n1 = idx1+1;
		int n2 = idx2;

		if (n1 < 0 || n1 >= H || n2 < 0 || n2 >= W || map[n1][n2] != '.') {
			i1 = idx1;
			i2 = idx2;
			map[i1][i2] = 'v';
			return false;
		} else {
			map[idx1][idx2] = '.';
			map[n1][n2] = 'v';
			i1 = n1;
			i2 = n2;
			return true;
		}
	}

	static boolean right(int idx1, int idx2) {

		int n1 = idx1;
		int n2 = idx2+1;

		if (n1 < 0 || n1 >= H || n2 < 0 || n2 >= W || map[n1][n2] != '.') {
			i1 = idx1;
			i2 = idx2;
			map[i1][i2] = '>';
			return false;
		} else {
			map[idx1][idx2] = '.';
			map[n1][n2] = '>';
			i1 = n1;
			i2 = n2;
			return true;
		}
	}

	static boolean left(int idx1, int idx2) {

		int n1 = idx1;
		int n2 = idx2-1;

		if (n1 < 0 || n1 >= H || n2 < 0 || n2 >= W || map[n1][n2] != '.') {
			i1 = idx1;
			i2 = idx2;
			map[i1][i2] = '<';
			return false;
		} else {
			map[idx1][idx2] = '.';
			map[n1][n2] = '<';
			i1 = n1;
			i2 = n2;
			return true;
		}
	}
	
	static void shoot(int idx1, int idx2) {
		if(map[idx1][idx2] == '^') {
			int n1 = idx1 -1; int n2 = idx2;
			
			while(n1 >= 0 && map[n1][n2] != '#') {
				if(map[n1][n2] == '*') {
					map[n1][n2] = '.';
					break;
				}
				n1 = n1 - 1;
				
			}
		}
		else if(map[idx1][idx2] == 'v') {
			int n1 = idx1+1; int n2 = idx2;
			
			while(n1 < H && map[n1][n2] != '#') {
				if(map[n1][n2] == '*') {
					map[n1][n2] = '.';
					break;
				}
				n1 = n1 + 1;
				
			}
		}
		else if(map[idx1][idx2] == '>') {
			int n1 = idx1; int n2 = idx2 +1;
			
			while(n2 < W && map[n1][n2] != '#') {
				if(map[n1][n2] == '*') {
					map[n1][n2] = '.';
					break;
				}
				n2 = n2 + 1;
				
			}
		}
		else if(map[idx1][idx2] == '<') {
			int n1 = idx1; int n2 = idx2-1;
			
			while(n2 >= 0 && map[n1][n2] != '#') {
				if(map[n1][n2] == '*') {
					map[n1][n2] = '.';
					break;
				}
				n2 = n2 - 1;
				
			}
		}
	}
}
