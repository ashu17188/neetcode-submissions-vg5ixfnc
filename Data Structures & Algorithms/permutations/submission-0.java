class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        permute(nums, new ArrayList<>(), pick);
        return res;
    }

    private void permute(int[] nums, List<Integer> perm, boolean[] pick) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                perm.add(nums[i]);
                permute(nums, perm, pick);

                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
}
