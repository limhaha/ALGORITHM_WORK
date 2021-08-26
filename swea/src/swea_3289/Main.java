package swea_3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, m;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            String[] input2 = br.readLine().split(" ");
            n = Integer.parseInt(input2[0]);
            m = Integer.parseInt(input2[1]);

            arr = new int[n + 1];
            make_set();

            for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
                int operator = Integer.parseInt(input[0]);
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);

                if (operator == 1) {
                    int A = find_set(a);
                    int B = find_set(b);
                    if (equal(A, B)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                } else if (operator == 0) {
                    union_set(a, b);
                }

            }
            System.out.print("#" + t+ " ");
            System.out.println(sb);
        }
    }

    public static void make_set() {
        for (int i = 1; i <= n; i++) {
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

    public static boolean equal(int a, int b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
