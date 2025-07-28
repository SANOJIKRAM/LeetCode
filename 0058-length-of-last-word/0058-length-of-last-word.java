class Solution {
    public int lengthOfLastWord(String s) {
        String words[]=s.split(" ");
        String last=words[words.length-1];
        int length = last.length();
        return length;
    }
}