import java.util.*;
import java.io.*;

public class Main {

    public static int n, m;
    public static int[][] arr;

    // 가능한 모든 모양을 전부 적어줌
    public static int[][][] shapes = new int[][][]{
            {{1, 1, 0},
             {1, 0, 0},
             {0, 0, 0}},

            {{1, 1, 0},
             {0, 1, 0},
             {0, 0, 0}},

            {{1, 0, 0},
             {1, 1, 0},
             {0, 0, 0}},

            {{0, 1, 0},
             {1, 1, 0},
             {0, 0, 0}},

            {{1, 1, 1},
             {0, 0, 0},
             {0, 0, 0}},

            {{1, 0, 0},
             {1, 0, 0},
             {1, 0, 0}},
    };

    // 주어진 위치에 대하여 가능한 모든 모양을 탐색하여 최대 합 반환
    public static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;
            for (int dx = 0; dx < 3; dx++) {
                for (int dy = 0; dy < 3; dy++) {
                    if (shapes[i][dx][dy] == 0) continue;
                    if (x + dx >= n || y + dy >= m) {
                        isPossible = false;
                        break;
                    }
                    sum += arr[x + dx][y + dy];
                }
                if (!isPossible) break;  // 추가된 부분
            }

            if (isPossible) maxSum = Math.max(maxSum, sum);
        }

        return maxSum;  // 추가된 부분
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, getMaxSum(i, j));
            }

        System.out.println(ans);
    }
}