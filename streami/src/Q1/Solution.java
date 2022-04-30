package Q1;

public class Solution {
    static boolean b_exi;
    static boolean result;
    public static void main(String[] args) {
        String S = "aaaba";
        System.out.println(solution(S));
    }

    public static boolean solution(String S) {
        b_exi = false;
        result = true;

        for (int i = 0; i<S.length(); i++) {
            if (S.charAt(i) == 'b') {
                b_exi = true;
            } else if (b_exi && S.charAt(i) == 'a') {
                result = false;
            }
        }
        return result;
    }
}
