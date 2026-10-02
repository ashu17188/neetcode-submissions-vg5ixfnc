class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<>(), 0, 0, target);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> currentList, int i, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(currentList));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        currentList.add(candidates[i]);
        dfs(candidates, currentList, i + 1, total + candidates[i], target);

        currentList.remove(currentList.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, currentList, i + 1, total, target);
    }
}
