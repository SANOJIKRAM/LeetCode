class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        char[] m = brokenLetters.toCharArray();
        String[] n = text.split(" ");

        int ans = 0;
        for (int i = 0; i < n.length; i++) {
            int count = 0;
            for (int j = 0; j < m.length; j++) {
                if (n[i].contains(Character.toString(m[j]))) {
                    count++;
                    break; // no need to check further broken letters for this word
                }
            }
            if (count == 0)
                ans++;
        }
        return ans;
    }
}
