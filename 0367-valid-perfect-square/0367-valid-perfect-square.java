public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true; // 1 is a perfect square
        }

        long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long midSquared = mid * mid;

            if (midSquared == num) {
                return true;
            } else if (midSquared < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
