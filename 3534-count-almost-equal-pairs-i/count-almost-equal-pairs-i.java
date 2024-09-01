class Solution {
    public int countPairs(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int m = i + 1; m < n; m++) {
                if (nums[m] == nums[i]) {
                    ans++;
                    continue;
                }

                StringBuilder sw = new StringBuilder((nums[m] < nums[i] ? nums[i] : nums[m]) + "");
                int cur = (nums[m] < nums[i] ? nums[m] : nums[i]);
                swap: for (int j = 0; j < sw.length() - 1; j++) {
                    for (int k = j + 1; k < sw.length(); k++) {
                        swap(j, k, sw);
                        int swapNum = Integer.valueOf(sw.toString());
                        //System.out.println(nums[i] + " " + swapNum + " " + nums[m]);
                        if (cur == swapNum) {
                            ans++;
                            //System.out.println(nums[i] + " " + swapNum + " " + nums[m]);
                            break swap;
                        }
                        swap(j, k, sw);
                    }
                }
            }
        }
        return ans;
    }

    private void swap(int j, int k, StringBuilder sw) {
        char c = sw.charAt(j);
        sw.setCharAt(j, sw.charAt(k));
        sw.setCharAt(k, c);
    }
}