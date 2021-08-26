package boj_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(input[i]);
        }

        int student = Integer.parseInt(br.readLine());
        for (int t = 0; t < student; t++) {
            String[] input2 = br.readLine().split(" ");
            int sex = Integer.parseInt(input2[0]);
            int num = Integer.parseInt(input2[1]);

            if (sex == 1) {
                for (int i=num; i<= N; i+=num) {
                    if (arr[i] == 0) {
                        arr[i] = 1;
                    } else {
                        arr[i] = 0;
                    }
                }
            }

            else{
                if(arr[num] ==1){
                    arr[num] = 0;
                }else{
                    arr[num] = 1;
                }
                int idx;
                if(N / num > 1){
                    idx = num -1;
                }else{
                    idx = N - num;
                }

                for (int i = 1; i <= idx; i++) {
                    if(arr[num+i] != arr[num-i]){
                        break;
                    }
                    if (arr[num + i] == 0) {
                        arr[num + i] = arr[num - i] = 1;
                    } else {
                        arr[num + i] = arr[num - i] = 0;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}