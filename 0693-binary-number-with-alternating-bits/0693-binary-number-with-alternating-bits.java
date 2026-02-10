class Solution {
    public boolean hasAlternatingBits(int n) {
        long allOnes = n ^ (n >> 1);
        return (allOnes & (allOnes + 1)) == 0;
    }
}
