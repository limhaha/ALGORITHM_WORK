package swea_7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean visited[];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            arr = new int[N + 1];
            visited = new boolean[N + 1];
            cnt = 0;
            make_set();

            for (int i = 0; i < M; i++) {
                String[] input2 = br.readLine().split(" ");
                int a = Integer.parseInt(input2[0]);
                int b = Integer.parseInt(input2[1]);
                union_set(a, b);
            }

            for (int i = 1; i <= N; i++) {
                visited[arr[i]] = true;
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i]) {
                    cnt++;
                }
            }
            System.out.print("#" + t + " ");
            System.out.println(cnt);
        }
    }

    public static void make_set() {
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
    }

    public static int find_set(int a) {
        if (arr[a] == a) {
            return a;
        }
        return arr[a] = find_set(arr[a]);
    }

    public static boolean union_set(int a, int b) {
        int aRoot = find_set(a);
        int bRoot = find_set(b);

        if (aRoot == bRoot) {
            return false;
        }
        arr[bRoot] = aRoot;
        return true;

    }
}
