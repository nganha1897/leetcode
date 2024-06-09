class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0, prefixMod = 0;
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        
        for (int i=0; i<nums.length; i++) {      
            prefixMod = (prefixMod + nums[i] % k + k) % k;
            ans += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return ans;
    }
}