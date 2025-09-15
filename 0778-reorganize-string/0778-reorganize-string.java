import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > (s.length() + 1) / 2)
                    return "";
                pq.offer(new int[] { i, count[i] });
            }
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char) (first[0] + 'a'));
            sb.append((char) (second[0] + 'a'));
            if (--first[1] > 0)
                pq.offer(first);
            if (--second[1] > 0)
                pq.offer(second);
        }

        if (!pq.isEmpty())
            sb.append((char) (pq.poll()[0] + 'a'));
        return sb.toString();
    }
}
