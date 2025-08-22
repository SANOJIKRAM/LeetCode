class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int shift = arr[i] - '0'; // convert digit char to int
            arr[i] = (char) (arr[i - 1] + shift); // shift previous char
        }
        return new String(arr);
    }
}
