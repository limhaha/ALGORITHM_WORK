//package boj_16234;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class Main {
//    static int N, L, R;
//    static int[][] A;
//    static boolean[][] visited;
//    static boolean[][] check;
//    static int[] dx = {1, 0, -1, 0};
//    static int[] dy = {0, 1, 0, -1};
//
//    static class Coordinate {
//
//        int x;
//        int y;
//
//        public Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        N = Integer.parseInt(input[0]);
//        L = Integer.parseInt(input[1]);
//        R = Integer.parseInt(input[2]);
//
//        A = new int[N][N];
//        check = new boolean[N][N];
//
//        for (int i = 0; i < N; i++) {
//            String[] input2 = br.readLine().split(" ");
//            for (int j = 0; j < N; j++) {
//                A[i][j] = Integer.parseInt(input2[j]);
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                for (int d = 0; d < 4; d++) {
//                    int nx = j + dx[d];
//                    int ny = i + dy[d];
//
//                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
//                        continue;
//                    }
//                    int sub = Math.abs(A[i][j] - A[nx][ny]);
//                    if(sub >= L && sub <= R){
//                        check[i][j] = true;
//                        check[ny][nx] = true;
//                    }
//                }
//            }
//        }
//
//
//    }
//
//    static int bfs(){
//        int cnt = 0;
//
//        for (int x = 0; x < N; x++) {
//            for (int y = 0; y < N; y++) {
//                if (!visited[x][y]) {
//                    Queue<Coordinate> queue = new LinkedList<>();
//                    Coordinate coordinate = new Coordinate(x, y);
//                    queue.add(coordinate);
//
//                    List<Coordinate> list = new ArrayList<>();
//                    list.add(coordinate);
//
//                    visited[coordinate.x][coordinate.y] = true;
//
//                }
//            }
//        }
//    }
//}
