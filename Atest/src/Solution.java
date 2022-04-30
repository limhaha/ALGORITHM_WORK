import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] now = new int[2];
    static int[] dx = {1, 0, -1, 1};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        now[0] = i;
                        now[1] = j;
                    }
                }
            }

//            for (int d = 0; d < 4; d++) {
//                int nx = now[1] + dx[d];
//                int ny = now[0] + dy[d];
//
//            }

            for (int i = 1; i <= now[0] ; i++) {
                while(map[now[0]-i][now[1]] == 1){
                    for(int j=0; )
                }
            }

            for (int i=0; i<N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
