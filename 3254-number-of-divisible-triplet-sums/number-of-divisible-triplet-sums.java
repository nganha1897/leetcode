class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[n-1] % d, map.getOrDefault(nums[n-1] % d, 0) + 1);
        
        for (int j=n-2; j>=0; j--) {
            for (int i=j-1; i>=0; i--) {
                int m = d - ((nums[i] + nums[j]) % d);
                if (m == d) {
                    m = 0;
                }
                ans += map.getOrDefault(m, 0);
            }
            map.put(nums[j] % d, map.getOrDefault(nums[j] % d, 0) + 1);
            //System.out.println(j + " " + map);
        }
        return ans;
    }
}