class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backTrack(nums, i + 1, subset);

        subset.remove(subset.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backTrack(nums, i + 1, subset);
    }
}
