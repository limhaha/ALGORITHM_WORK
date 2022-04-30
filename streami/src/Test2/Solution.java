package Test2;

import java.util.Arrays;

public class Solution {
    static int[] temp;
    static int[] arr;
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        System.out.println(Arrays.toString(solution(A, K)));
    }
    static int[] solution(int[] A, int K) {
        temp = new int[A.length];
        arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }
        for (int a=0; a<K; a++) {
            for (int i=0; i<arr.length; i++) {
                temp[i] = arr[i];
            }
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i+1] = temp[i];
            }
            arr[0] = temp[arr.length- 1];
        }

        return arr;
    }
}
