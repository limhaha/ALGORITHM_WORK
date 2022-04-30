package swea_5643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] map = new int[N + 1][N + 1];

            int start, end;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                map[start][end] = 1;
            }

            for(int i = 1; i <= N; i++)
            {
                for(int j = 1; j <= N; j++)
                {
                    for(int k = 1; k <= N; k++)
                    {
                        if(i == j || j == k || i == k) continue;
                        if(map[j][k] == 0)
                        {
                            if(map[j][i] == 1 && map[i][k] == 1) map[j][k] = 1;
                        }
                    }
                }
            }

            boolean check;
            int sum = 0;

            for (int i = 1; i <= N; i++) {
                check = false;
                for (int j = 1; j <= N; j++) {
                    if (i != j && map[i][j] == 0 && map[j][i] == 0) {
                        check = true;
                        break;
                    }
                }
                if (!check) sum++;
            }

            System.out.print("#" + t + " ");
            System.out.println(sum);
        }
    }
}
