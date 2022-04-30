package Q3;

public class Solution {
    static int not;
    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {1,2};
        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i])
                continue;
            // otherwise whichever number is smaller in both arrays is rejected from the
            // merged array
            int rejectElement = (A[i] < B[i]) ? A[i] : B[i];
            if (A[i] < B[i]) {
                not = A[i];
            }
            // now comparing if its the lowest in all rejected ones.
            min = (rejectElement < min) ? rejectElement : min;
        }

        // if the arrays are identical then return largest element +1
//        return (minimumRejectedElement == Integer.MAX_VALUE) ? A[len - 1] + 1 : minimumRejectedElement;
        return 0;
    }

}
