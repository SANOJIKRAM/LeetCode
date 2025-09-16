import java.util.*;

public class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String pattern : allowed) {
            String key = pattern.substring(0, 2);
            char val = pattern.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        if (bottom.length() == 1)
            return true;

        List<StringBuilder> candidates = new ArrayList<>();
        candidates.add(new StringBuilder());

        for (int i = 0; i < bottom.length() - 1; i++) {
            String pair = bottom.substring(i, i + 2);
            if (!map.containsKey(pair)) {
                return false;
            }
            List<Character> tops = map.get(pair);

            List<StringBuilder> newCandidates = new ArrayList<>();
            for (StringBuilder sb : candidates) {
                for (char c : tops) {
                    StringBuilder newSb = new StringBuilder(sb);
                    newSb.append(c);
                    newCandidates.add(newSb);
                }
            }
            candidates = newCandidates;
        }

        for (StringBuilder nextBottom : candidates) {
            if (dfs(nextBottom.toString())) {
                return true;
            }
        }

        return false;
    }
}
