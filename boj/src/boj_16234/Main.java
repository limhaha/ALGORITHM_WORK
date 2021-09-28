package boj_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int N, L, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (bfs()) {
            ans++;
        }
        System.out.println(ans);

    }

    private static boolean bfs() {
        Queue<XY> q = new LinkedList<XY>();
        boolean[][] visited = new boolean[N][N];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    q.offer(new XY(i, j));
                    visited[i][j] = true;

                    int sum = map[i][j]; // 평균 계산 위한 인구 sum과
                    int countryCnt = 1; // 연합을 이루는 나라 수 카운트

                    ArrayList<XY> list = new ArrayList<XY>();
                    list.add(new XY(i, j));

                    while (!q.isEmpty()) { // bfs 돌며 연합할 나라 탐색
                        XY temp = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nr = temp.x + dr[d];
                            int nc = temp.y + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
                                continue;

                            if (Math.abs(map[temp.x][temp.y] - map[nr][nc]) >= L
                                    && Math.abs(map[temp.x][temp.y] - map[nr][nc]) <= R) {
                                visited[nr][nc] = true;
                                q.offer(new XY(nr, nc));

                                list.add(new XY(nr, nc)); // 연합국의 좌표 따로 리스트에 저장

                                sum += map[nr][nc];
                                countryCnt++;
                            }
                        }
                    }

                    int pop = sum / countryCnt;
                    for (int k = 0; k < list.size(); k++) {
                        XY t = list.get(k);
                        map[t.x][t.y] = pop;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();

        if (cnt == N * N) { // 종료조건
            return false;
        }

        return true;
    }

    static class XY {
        int x, y;

        public XY(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}