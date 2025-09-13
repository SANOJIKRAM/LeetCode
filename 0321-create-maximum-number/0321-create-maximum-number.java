public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        int m = nums1.length, n = nums2.length;

        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] subseq1 = maxSubsequence(nums1, i);
            int[] subseq2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(subseq1, subseq2);
            if (greater(candidate, 0, max, 0)) {
                max = candidate;
            }
        }
        return max;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1, toRemove = nums.length - k;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && toRemove > 0) {
                top--;
                toRemove--;
            }
            if (top + 1 < k) {
                stack[++top] = num;
            } else {
                toRemove--;
            }
        }
        return stack;
    }

    private int[] merge(int[] subseq1, int[] subseq2) {
        int x = subseq1.length, y = subseq2.length;
        int[] merged = new int[x + y];
        int i = 0, j = 0, idx = 0;

        while (i < x || j < y) {
            if (greater(subseq1, i, subseq2, j)) {
                merged[idx++] = i < x ? subseq1[i++] : subseq2[j++];
            } else {
                merged[idx++] = j < y ? subseq2[j++] : subseq1[i++];
            }
        }
        return merged;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
