import java.util.Scanner;
 
public class SWEA_1210_Ladder1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int i = 0; i < 10; i++) {
            int test_case = sc.nextInt();
            // 사다리 정보 저장
            int[][] ladder = new int[100][100];
            for(int a = 0; a < 100; a++) {
                for(int b = 0; b < 100; b++) {
                    ladder[a][b] = sc.nextInt();
                }
            }
 
            int result = 0;
 
             
            /////////////////////////////////////////////////////
            // 먼저 출구를 찾아보았다.
            for (int a = 0; a < 100; a++) {
                // 출발점인 부분은 1이다!
                if (ladder[0][a] == 1) {
                    int idx = a;
                    for (int b = 1; b < 99; b++) {
                        // 오른쪽으로 갔을 때 범위를 벗어나지 않고, 오른쪽 값이 1이라면
                        if ((idx + 1) < 100 && ladder[b][idx + 1] == 1) {
                            // 오른쪽이 다시 0이거나 범위를 벗어날때 까지 idx값을 증가시킨다.
                            while ((idx + 1) < 100 && ladder[b][idx + 1] == 1) {
                                idx++;
                            }
                        } 
                         
                        else if ((idx - 1) >= 0 && ladder[b][idx - 1] == 1) {
                            while ((idx - 1) >= 0 && ladder[b][idx - 1] == 1) {
                                idx--;
                            }
                        }
                    }
                    if (ladder[99][idx] == 2) {
                        result = a;
                        break;
                    }
                }
            }
            /////////////////////////////////////////////////////
            System.out.printf("#%d %d%n", test_case, result);
        }
    }
}