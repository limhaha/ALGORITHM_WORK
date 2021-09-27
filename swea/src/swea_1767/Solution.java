package swea_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Core> list;
    static int minWire, maxCore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        map[i][j] = input;

                        //가장자리 있는 코어는 리스트 저장 안함
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            continue;
                        }
                        list.add(new Core(j, i));
                    }
                }
            }

            minWire = Integer.MAX_VALUE;
            maxCore = Integer.MIN_VALUE;

            dfs(0, 0, 0);
            System.out.println("#" + t + " " + minWire);

        } //end of testcase
    } //end of main

    public static void dfs(int idx, int coreCnt, int wireCnt) {
        if (idx == list.size()) {
            if (maxCore < coreCnt) {
                maxCore = coreCnt;
                minWire = wireCnt;
            } else if (maxCore == coreCnt) {
                minWire = Math.min(wireCnt, minWire);
            }
            return;
        }

        int x = list.get(idx).x;
        int y = list.get(idx).y;

        for (int d = 0; d < 4; d++) {
            int cnt = 0;
            int nx = x;
            int ny = y;

            while (true) {

                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    break;
                }

                if (map[ny][nx] == 1) {
                    cnt = 0;
                    break;
                }
                cnt++;
            }
            int fill_x = x;
            int fill_y = y;

            for (int i = 0; i < cnt; i++) {
                fill_x += dx[d];
                fill_y += dy[d];
                map[fill_y][fill_x] = 1;
            }

            if (cnt == 0) {
                dfs(idx + 1, coreCnt, wireCnt);
            } else {
                dfs(idx + 1, coreCnt + 1, wireCnt + cnt);


                fill_x = x;
                fill_y = y;

                // 다시 0으로 채우기
                for (int i = 0; i < cnt; i++) {
                    fill_x += dx[d];
                    fill_y += dy[d];
                    map[fill_y][fill_x] = 0;
                }
            }
        }
    }

    static class Core {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
