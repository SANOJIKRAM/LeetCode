class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        while (true) {
            if (digitProduct(num) % t == 0) {
                return num;
            }
            num++;
        }
    }

    private int digitProduct(int x) {
        int product = 1;
        if (x == 0)
            return 0;
        while (x > 0) {
            int d = x % 10;
            product *= d;
            x /= 10;
        }
        return product;
    }
}
