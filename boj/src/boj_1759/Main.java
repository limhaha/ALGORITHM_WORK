package boj_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int L,C;
    static char chars[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        String[] input2 = br.readLine().split(" ");

        chars = new char[C];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            chars[i] = input2[i].charAt(0);
        }

        Arrays.sort(chars);
        combination(0, 0);
    }

    private static void combination(int start, int cnt) {
        if (cnt == L) {
            int vowel = 0;
            int consonant = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    sb.append(chars[i]);

                    if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                        vowel++;
                    } else {
                        consonant++;
                    }
                }
            }
            if (vowel >= 1 && consonant >= 2) {
                System.out.println(sb);
            }

        }
        for (int i = start; i < C; i++) {
            visited[i] = true;
            combination(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
