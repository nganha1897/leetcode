class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int lo = 0, hi = ans.size();
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (ans.get(mid) < nums[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo < ans.size() && ans.get(lo) > nums[i]) {
                ans.set(lo, nums[i]);
            } else if (lo == ans.size()) {
                ans.add(nums[i]);
            }
            //System.out.println(i + " " + lo + " " + ans);
        }
        return ans.size();
    }
}