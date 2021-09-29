package boj_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Set set = new HashSet();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cur = arr[0];
        int top = arr[0];
        int cnt = 1;

        for (int i = 1; i < N; i++) {
            if(arr[i] > top){
                cur = arr[i];
                top = arr[i];
                set.add(cnt);
                cnt = 1;
                System.out.println("arr[i] > top " + cnt);
                continue;
            } if (arr[i] < cur) {
                cur = arr[i];
                cnt++;
                set.add(cnt);
                System.out.println("arr[i] < cur " + cnt + " " + cur);
            }
            if(arr[i] >= cur){
                cur = arr[i];
                set.add(cnt);
                System.out.println("arr[i] >= cur " + cnt + " "+ cur);
            }
        }
        System.out.println(Collections.max(set));
    }
}
