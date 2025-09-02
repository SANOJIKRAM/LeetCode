class Solution {
public:
    string reverseWords(string s) {
        int start = 0, n = s.size();
        for (int end = 0; end <= n; ++end) {
            if (end == n || s[end] == ' ') {
                reverse(s.begin() + start, s.begin() + end);
                start = end + 1;
            }
        }
        return s;
    }
};
