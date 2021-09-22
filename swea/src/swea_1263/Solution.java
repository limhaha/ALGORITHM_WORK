package swea_1263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    static int INF = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i != j && map[i][j] == 0) {
                        map[i][j] = INF;
                    }
                }
            }
            for(int k = 0; k < N; k++ ) { //경유지 k
                for(int i = 0; i < N; i++) {//출발지  i
                    if(k == i) {
                        continue;
                    }
                    for(int j = 0; j < N; j++) {//도착지 j
                        if(j == i || j == k) {
                            continue;
                        }
                        if(map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
            int min = INF;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        sum += map[i][j];
                    }
                    min = Math.min(sum, min);
                }
            }
            System.out.println(min);

        }
    }
}
