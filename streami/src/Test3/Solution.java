package Test3;

public class Solution {
    static int max;
    static int[] odd;
    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A));
    }

    static int solution(int[] A) {
        max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }
        odd = new int[max+1];
        for (int i = 0; i < A.length; i++) {
            odd[A[i]]++;
        }
        int idx =0;
        for (int i = 0; i < odd.length; i++) {
            if (odd[i] == 1) {
                idx = i;
            }
        }
        return idx;
    }
}
