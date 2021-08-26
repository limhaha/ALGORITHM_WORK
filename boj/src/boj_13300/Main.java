package boj_13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        map = new int[6][2];

        cnt=0;
        for (int n = 0; n < N; n++) {
            String[] input2 = br.readLine().split(" ");
            int sex = Integer.parseInt(input2[0]);
            int grade = Integer.parseInt(input2[1]) -1;

            map[grade][sex]++;
            if(map[grade][sex] >= K){
                map[grade][sex] = 0;
                cnt++;
            }
        }
        for(int i=0; i<6; i++){
            for (int j = 0; j < 2; j++) {
                if(map[i][j] != 0){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
