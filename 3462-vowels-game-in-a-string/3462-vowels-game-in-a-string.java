class Solution {
    public boolean doesAliceWin(String s) {
        char[] sun = s.toCharArray();
        int count=0;
        for (char n:sun){
            if (n=='a'||n=='e'||n=='i'||n=='o'||n=='u') count++;
        }
        return count > 0;
    }
}