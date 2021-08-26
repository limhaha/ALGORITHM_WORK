package boj_1592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int cnt;
    static int cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);

        arr = new int[N];
        cur = 0;
        cnt = -1;

        while(true){

            arr[cur]++;
            cnt++;

            if(arr[cur] == M){
                break;
            }
            if (cur + L >= N) {
                cur = cur + L - N;
            }else{
                cur = cur + L;
            }
        }
        System.out.println(cnt);
    }
}
