public class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int[] row : image) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
            for (int i = 0; i < n; i++) {
                row[i] = 1 - row[i];
            }
        }
        return image;
    }
}