class Solution {
    public int balancedStringSplit(String s) {
        int balance = 0; // tracks balance between 'L' and 'R'
        int count = 0; // counts balanced strings

        for (char c : s.toCharArray()) {
            if (c == 'R')
                balance++;
            else
                balance--;

            if (balance == 0)
                count++;
        }

        return count;
    }
}
