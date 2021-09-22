package swea_3307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] LIS = new int[N];

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            int max = 0;
            for(int i = 0; i < N; i++) {
                LIS[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(arr[j] < arr[i]) { // 내가 앞 숫자 보다 크면
                        if(LIS[i] < LIS[j]+1) { // 기존것 보다 j 뒤에 i를 넣으면 유리하면
                            LIS[i] = LIS[j]+1;

                        }
                    }
                } // i를 끝으로 하는 최장길이 구함
                max = Math.max(max, LIS[i]); // 얻고자 하는 최장 길이 구하기
            }
            System.out.print("#" + t + " ");
            System.out.println(max); // 전체길이의 최대값
        }
    }

}
