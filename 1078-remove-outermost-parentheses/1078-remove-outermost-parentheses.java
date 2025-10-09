class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (openCount > 0) { // Not outermost '('
                    result.append(c);
                }
                openCount++;
            } else {
                openCount--;
                if (openCount > 0) { // Not outermost ')'
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
