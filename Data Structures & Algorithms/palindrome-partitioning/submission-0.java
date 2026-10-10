class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> part = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int j, int i) {
        if (i >= s.length()) {
            if (i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }

        if (isPali(s, j, i)) {
            part.add(s.substring(j, i + 1));
            dfs(s, i + 1, i + 1);
            part.remove(part.size() - 1);
        }

        dfs(s, j, i + 1);
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
