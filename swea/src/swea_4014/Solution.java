package swea_4014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int N, X, ans;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 0;
            connect();

            sb.append("#").append(testCase).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void connect() {
        for (int i = 0; i < map.length; i++) {

            boolean[] flag = new boolean[map.length];
            boolean isPossible = true;
            here:  // 어떻게 쓰는지 잘 모르겠음
            for (int j = 0; j < map.length - 1; j++) {

                if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
                    isPossible = false;
                    break;
                } else {
                    if (map[i][j] - map[i][j + 1] == 0) continue;

                    else if (map[i][j] - map[i][j + 1] == -1) {


                        for (int k = j; k > j - X; k--) {
                            if (k >= 0 && !flag[k] && map[i][k] == map[i][j + 1] - 1) flag[k] = true;
                            else {
                                isPossible = false;
                                break here;
                            }
                        }

                    } else {

                        for (int k = j + 1; k < X + j + 1; k++) {

                            if (k < N && !flag[k] && map[i][k] == map[i][j] - 1) flag[k] = true;
                            else {
                                isPossible = false;
                                break here;
                            }
                        }
                    }
                }
            }

            if (isPossible) ans++;
        }

        for (int i = 0; i < map.length; i++) {

            boolean[] flag = new boolean[map.length];
            boolean isPossible = true;
            here:
            for (int j = 0; j < map.length - 1; j++) {

                if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
                    isPossible = false;
                    break;
                } else {
                    if (map[j][i] - map[j + 1][i] == 0) continue;

                    else if (map[j][i] - map[j + 1][i] == -1) {

                        for (int k = j; k > j - X; k--) {
                            if (k >= 0 && !flag[k] && map[k][i] == map[j + 1][i] - 1) flag[k] = true;
                            else {
                                isPossible = false;
                                break here;
                            }
                        }
                    } else {

                        for (int k = j + 1; k < X + j + 1; k++) {
                            if (k < N && !flag[k] && map[k][i] == map[j][i] - 1) flag[k] = true;
                            else {
                                isPossible = false;
                                break here;
                            }
                        }
                    }
                }
            }

            if (isPossible) ans++;
        }
    }

}
