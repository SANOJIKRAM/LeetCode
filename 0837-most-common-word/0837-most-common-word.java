class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String normalized = paragraph.toLowerCase().replaceAll("[!?',;\\.]", " ");
        String[] words = normalized.split(" ");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word) && word.length() > 0) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostCommon;
    }
}
