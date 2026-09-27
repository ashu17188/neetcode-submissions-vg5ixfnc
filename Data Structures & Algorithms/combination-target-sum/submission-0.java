class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        dfs(nums, cur, 0, 0, target);
        return res;
    }

    private void dfs(int[] nums, List<Integer> cur, int i, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (i >= nums.length || total > target) {
            return;
        }

        cur.add(nums[i]);
        dfs(nums, cur, i, total + nums[i], target);

        cur.remove(cur.size() - 1);
        dfs(nums, cur, i + 1, total, target);
    }
}
