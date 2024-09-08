class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void subsets(int[] nums, int cur, List<List<Integer>> ans, List<Integer> list) {
        if (cur == nums.length) {
            ans.add(list);
            return;
        }
        subsets(nums, cur+1, ans, new ArrayList(list));
        list.add(nums[cur]);
        subsets(nums, cur+1, ans, list);
    }
}