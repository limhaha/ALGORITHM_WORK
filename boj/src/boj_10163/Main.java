package boj_10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[101][101];

        for (int n = 1; n <= N; n++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int width = Integer.parseInt(input[2]);
            int height = Integer.parseInt(input[3]);

            for (int i = x; i < x + width; i++) {
                for (int j = y; j < y + height; j++) {
                    map[i][j] = n;
                }
            }
        }


        for (int n = 1; n <= N; n++) {
            int cnt = 0;
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if (map[i][j] == n) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
