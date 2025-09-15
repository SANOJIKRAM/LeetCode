class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int ans = 0;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int move = 1; move <= maxMove; move++) {
            int[][] newDp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int ways = dp[i][j];
                    if (ways > 0) {
                        for (int[] d : dirs) {
                            int ni = i + d[0];
                            int nj = j + d[1];
                            if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                                ans = (ans + ways) % MOD;
                            } else {
                                newDp[ni][nj] = (newDp[ni][nj] + ways) % MOD;
                            }
                        }
                    }
                }
            }
            dp = newDp;
        }

        return ans % MOD;
    }
}
