public class Solution {
        public int minDeletionSize(String[] strs) {
                int n = strs.length, m = strs[0].length();
                        int[] dp = new int[m];
                                int maxLen = 1;

                                        for (int i = 0; i < m; i++) {
                                                    dp[i] = 1;
                                                                for (int j = 0; j < i; j++) {
                                                                                boolean nonDecreasing = true;
                                                                                                for (int k = 0; k < n; k++) {
                                                                                                                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                                                                                                                                            nonDecreasing = false;
                                                                                                                                                                    break;
                                                                                                                                                                                        }
                                                                                                                                                                                                        }
                                                                                                                                                                                                                        if (nonDecreasing) {
                                                                                                                                                                                                                                            dp[i] = Math.max(dp[i], dp[j] + 1);
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    maxLen = Math.max(maxLen, dp[i]);
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                    return m - maxLen;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        }

