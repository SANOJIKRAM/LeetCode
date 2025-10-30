class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int v : nums) {
            count.put(v, count.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        int a = 0;
        for (int b : count.values()) {
            int c = n - a - b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }
}
