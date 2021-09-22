package boj_2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 1) {
            System.out.println(0);
        } else {
            int[] memo = new int[N + 4];
            memo[2] = 3;
            memo[4] = 11;

            for (int i = 6; i <= N; i++) {
                if (N % 4 == 0) {
                    memo[i] = memo[i - 2] * 3 + memo[i - 4] * 2;
                } else {
                    memo[i] = memo[i - 2] * 3;
                }
            }
            System.out.println(memo[N]);
        }


    }
}
