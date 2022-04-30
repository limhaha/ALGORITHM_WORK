package Q2;

public class Solution {

    static int start;
    static int cnt;
    public static void main(String[] args) {
//        String S = "011100";
        String S = "1";
        System.out.println(solution(S));
    }

    public static int solution(String S) {
        start = 0;
        cnt = 1;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                break;
            } else {
                start++;
            }
        }
        for (int i = start+1; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                cnt += 2;
            } else if (S.charAt(i) == '0') {
                cnt += 1;
            }
        }

        return cnt;
    }
}
