import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {

    static int N; //정점 개수
    static boolean[][] adjMatrix; // 인접행렬 (가중치없음)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adjMatrix = new boolean[N][N];
        int C = Integer.parseInt(br.readLine()); // 간선 개수
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = true;
            adjMatrix[to][from] = true;

        }
        System.out.println("===========bfs==========");
        bfs();
        System.out.println("===========dfs==========");
        boolean[] visited = new boolean[N];

        dfs(0, visited);

    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N];
        queue.offer(0);

        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            System.out.println((char) (current + 65));

            //방문하지 않은 노드 큐에 삽입
            for (int i = 0; i < N; i++) {
                if (!visited[i] && adjMatrix[current][i]) { // 방문하지않았고 인접정점인지
                    queue.offer(i); // 지금 탐색이 아니라 큐에 넣고 순서를 기다린다
                    visited[i] = true; // 큐에 넣었으면 방문처리
                }
            }
        }
    }

    public static void dfs(int current, boolean[] visited) {

        visited[current] = true;
        System.out.println((char) (current + 65));

        for (int i = 0; i < N; i++) {
            if (!visited[i] && adjMatrix[current][i]) { // 방문하지않았고 인접정점인지

                dfs(i, visited);
            }
        }
    }
}
