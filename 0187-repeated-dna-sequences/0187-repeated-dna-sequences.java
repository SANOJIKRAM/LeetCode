import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        List<String> result = new ArrayList<>();

        int len = 10;
        if (s.length() < len)
            return result;

        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (seen.contains(sub)) {
                repeated.add(sub);
            } else {
                seen.add(sub);
            }
        }

        result.addAll(repeated);
        return result;
    }
}
