class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] ans = new int[queries.length];
        List<Integer> idx = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == x) {
                idx.add(i);
            }
        }
        for (int i=0; i<queries.length; i++) {
            if (queries[i] > idx.size()) {
                ans[i] = -1;
            } else {
                ans[i] = idx.get(queries[i] - 1);
            }
        }
        return ans;
    }
}