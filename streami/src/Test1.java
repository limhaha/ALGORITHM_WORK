public class Test1 {
    static int dec;
    static int cnt;
    static int max;
    public static void main(String[] args) {
        dec = 32;

        System.out.println(solution(dec));
    }

    static int solution(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        max = 0;
        cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                max = Math.max(max, cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return max;
    }
}
