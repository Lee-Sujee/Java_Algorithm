import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
import java.util.StringTokenizer;
 
public class SWEA_8275_햄스터 {
    static int N, X, M;
    static int[][] hamzzi;
    static int[] ham;
    static int[] ans;
    static int max;
    static boolean isExist;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
             
            N = Integer.parseInt(st.nextToken()); // 우리 수 
            X = Integer.parseInt(st.nextToken()); // 최대 햄스터 수
            M = Integer.parseInt(st.nextToken()); // 기록 개수
            hamzzi = new int[M][3];
            ham = new int[N];
            isExist = false;
            ans = new int[N];
            max = Integer.MIN_VALUE;
             
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                hamzzi[i][0] = Integer.parseInt(st.nextToken());
                hamzzi[i][1] = Integer.parseInt(st.nextToken());
                hamzzi[i][2] = Integer.parseInt(st.nextToken());
            }
             
            hamster(0);
            sb.append("#" + t + " ");
            if(!isExist) {
                sb.append("-1\n");
            }
            else {
                for(int i = 0; i < N; i++) {
                    sb.append(ans[i] + " ");
                }
                sb.append("\n");
            }
             
 
        } // 테스트 케이스
        System.out.println(sb);
         
    }
     
     
    public static void hamster(int idx) {
    // ham에 배치해보자...
        if(idx == N) {
            check();
            return;
        }
         
        //0~X 중에 하나씩 ham의 배열 안에 저장한다. -> 완료!!
        for(int i = 0; i <= X; i++) {
            ham[idx] = i;
            hamster(idx+1);
        }
    }
     
    public static void check() {
        // 기록과 전부 일치하는지 확인해볼까??
        for(int i = 0; i < M; i++) {
            int tmp = 0;
            for(int j = hamzzi[i][0]-1; j < hamzzi[i][1]; j++) {
                tmp+=ham[j];
            }
            if(tmp != hamzzi[i][2]) return;
        }
         
        // 모두 일치한다면 여기까지 내려왔을거야!
        // 방문처리 해주자!
        int sum = 0;
        isExist = true;
        for(int i = 0; i < N; i++) {
            sum += ham[i];
        }
         
 
        if(sum > max) {
            max = sum;
            // max 값이 업데이트 되는 시점에서만 ans를 업데이트 해주면 된다!
            for(int i = 0; i < ham.length; i++) {
                ans[i] = ham[i];
            }
        }
    }
}