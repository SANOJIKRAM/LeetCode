class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                required[Character.toLowerCase(c) - 'a']++;
            }
        }

        String result = null;
        for (String word : words) {
            if (canComplete(word, required)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean canComplete(String word, int[] required) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] < required[i]) {
                return false;
            }
        }
        return true;
    }
}
