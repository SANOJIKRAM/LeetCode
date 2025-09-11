class Solution {
    public int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        boolean inSegment = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (!inSegment) {
                    count++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }
        return count;
    }
}
