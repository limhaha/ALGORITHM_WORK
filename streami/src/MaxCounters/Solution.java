package MaxCounters;

import java.util.Arrays;

public class Solution {
    static int max;
    static int[] arr;
    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;

        System.out.println(Arrays.toString(solution(N, A)));

    }

    public static int[] solution(int N, int[] A) {
        arr = new int[N];
        max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N+1) {
                for (int j = 0; j < N; j++) {
                    arr[j] = max;
                }
            } else {
                arr[(A[i] - 1)]++;
                max = Math.max(arr[(A[i] - 1)], max);
            }
        }
        return arr;
    }
}