import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
    
        if (current.size() == 4) {
          
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

      
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length())
                break;

            String part = s.substring(start, start + len);

            if (isValid(part)) {
                current.add(part);
                backtrack(s, start + len, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isValid(String part) {
        if (part.length() > 1 && part.startsWith("0"))
            return false; // no leading zeroes
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}
