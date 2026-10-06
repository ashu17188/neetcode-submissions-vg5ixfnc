class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backTrack(0, 0, n, res, stack);
        return res;
    }

    private void backTrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (openN == closedN && closedN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backTrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (openN > closedN) {
            stack.append(')');
            backTrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
