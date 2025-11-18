class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] prime = new boolean[21];
        fillPrimes(prime);

        int count = 0;

        for (int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);
            if (prime[setBits]) {
                count++;
            }
        }

        return count;
    }

    private void fillPrimes(boolean[] prime) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };
        for (int p : primes) {
            prime[p] = true;
        }
    }
}
