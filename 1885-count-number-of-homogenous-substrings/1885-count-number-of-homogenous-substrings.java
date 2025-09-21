public class Solution {
    private static final int MOD = 1000000007;
    public int countHomogenous(String s) {
        int n = s.length();
        long total = 0;
        long count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                total = (total + count * (count + 1) / 2) % MOD;
                count = 1;
            }
        }
        total = (total + count * (count + 1) / 2) % MOD;
        return (int) total;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countHomogenous("abbcccaa"));
        System.out.println(solution.countHomogenous("xy"));
        System.out.println(solution.countHomogenous("zzzzz"));
    }

}