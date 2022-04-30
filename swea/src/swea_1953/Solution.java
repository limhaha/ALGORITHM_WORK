package swea_1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static String[] type = {
            null,
            "0312",
            "03",
            "12",
            "02",
            "32",
            "31",
            "01",
    };
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};
    private static int N, M, R, C, L, map[][];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(in.readLine());

        StringTokenizer st = null;
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#" + tc + " " + bfs());
        }
    }

    private static int bfs() {

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[N][M];
        int result = 0, time = 1;

        queue.offer(new int[]{R, C});
        visited[R][C] = true;
        result++;

        int r, c, nr, nc, size, current[], dir;
        String info = null;
        while (time++ < L) {
            size = queue.size();
            while (size-- > 0) {
                current = queue.poll();
                r = current[0];
                c = current[1];
                info = type[map[r][c]];

                for (int d = 0, length = info.length(); d < length; d++) {
                    dir = info.charAt(d) - '0';
                    nr = r + dr[dir];
                    nc = c + dc[dir];

                    if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0
                            && type[map[nr][nc]].contains(Integer.toString(3 - dir))
                            && !visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
