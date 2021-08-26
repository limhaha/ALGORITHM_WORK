package boj_2567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[102][102];

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            for (int i = x+1; i <= x + 10; i++) {
                for (int j = y+1; j <= y + 10; j++) {
                    map[i][j] = 1;
                }
            }
        }
        result = 0;

        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {

                if (map[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {

                        int ny = i + dx[d];
                        int nx = j + dy[d];
                        if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) {
                            continue;
                        }
                        if (map[ny][nx] == 0) {
                            result++;
                        }
                    }
                }

            }
        }

        System.out.println(result);
    }
}
