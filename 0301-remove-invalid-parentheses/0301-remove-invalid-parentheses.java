import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null)
            return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (isValid(curr)) {
                res.add(curr);
                found = true;
            }
            if (found)
                continue;

            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')')
                    continue;
                String next = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return res.isEmpty() ? Collections.singletonList("") : res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')') {
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }
}
