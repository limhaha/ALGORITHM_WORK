package boj_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int W, H;
    static int[][] map;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[0]);
        map = new int[H][W];

        for (int i = 0; i < W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < H; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(res);
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] hdx = {-2,-1,1,2,2,1,-1,-2};
    static int[] hdy = {-1,-2,-2,-1,1,2,2,1};

    private static void bfs() {
        Queue<Data> queue = new LinkedList<Data>();
        //큐 삽입
        boolean[][][] visited = new boolean[K + 1][H][W];
        // 방문체크 초기화
        queue.offer(new Data(0, 0, 0, 0));
        visited[0][0][0] = true;

        //큐반복
        Data cur;
        while (!queue.isEmpty()) {
            //도착지 확인
            cur = queue.poll();
            if (cur.x == W - 1 && cur.y == H - 1) {
                res = cur.cnt;
                break;
            }

            //원숭이 이동
            int nx, ny;
            for (int d = 0; d < 4; d++) {
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];

                //범위체크
                if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
                    continue;
                }
                //방문체크
                if(visited[cur.k][ny][nx]){
                    continue;
                }
                //장애물 체크
                if (map[nx][ny] == 1) {
                    continue;
                }

                queue.offer(new Data(nx, ny, cur.cnt + 1, cur.k));
                visited[cur.k][ny][nx] = true;
            }
            //말이동
            //말 이동(if k)
            if(cur.k + 1<= K) { // 치트키 사용가능하면 말이동
                for(int d = 0; d < 8; d++) {
                    nx = cur.x + hdx[d];
                    ny = cur.y + hdy[d];
//                    범위체크
                    if(nx < 0 || nx >=W || ny < 0 || ny >= H) {
                        continue;
                    }
//                    방문체크
                    if(visited[cur.k+1][ny][nx]) {
                        continue;
                    }
//                    장애물체크
                    if(map[ny][nx] == 1) {
                        continue;
                    }
//                    큐에 삽입
                    queue.offer(new Data(nx, ny, cur.cnt + 1, cur.k+1)); // 치트키 사용 함
                    visited[cur.k + 1][ny][nx] = true;
                }
            }
        }
    }


    static class Data{
        int x, y;
        int cnt;
        int k;

        public Data(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }
}



