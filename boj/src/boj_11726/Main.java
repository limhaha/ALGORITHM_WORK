package boj_11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] memo = new long[N + 1];
        memo[0] = 1;
        memo[1] = 2;

        for (int i = 2; i < N; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
        }

        System.out.println(memo[N - 1] );
    }
}
