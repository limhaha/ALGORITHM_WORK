package boj_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp;
    static int[] rgb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];
        rgb = new int[3];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rgb[j] = Integer.parseInt(input[j]);
            }
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[2];


        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
