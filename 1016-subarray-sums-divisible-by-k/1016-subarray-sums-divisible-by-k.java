import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixModCount = new HashMap<>();
        prefixModCount.put(0, 1); 
        for (int num : nums) {
            prefixSum += num;
            int mod = prefixSum % k;
            if (mod < 0) {
                mod += k;
            }

            if (prefixModCount.containsKey(mod)) {
                count += prefixModCount.get(mod);
                prefixModCount.put(mod, prefixModCount.get(mod) + 1);
            } else {
                prefixModCount.put(mod, 1);
            }
        }
        return count;
    }
}
