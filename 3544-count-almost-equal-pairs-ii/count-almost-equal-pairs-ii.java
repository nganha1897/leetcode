class Solution {
    public int countPairs(int[] nums) {
        HashMap<Integer, Integer> swapMap = new HashMap<>();
        //HashMap<Integer, Integer> originMap = new HashMap<>();
        int ans = 0;
        Arrays.sort(nums);
        // for (int num : nums) {
        //     originMap.put(num, originMap.getOrDefault(num, 0) + 1);
        // }

        for (int i=nums.length-1; i>=0; i--) {
            ans += swapMap.getOrDefault(nums[i], 0);
            StringBuilder s = new StringBuilder(nums[i] + "");
            int len = s.length();
            HashMap<Integer, Integer> curSwapMap = new HashMap<>();
            curSwapMap.put(nums[i], curSwapMap.getOrDefault(nums[i], 0) + 1);
            for (int m=0; m<len-1; m++) {
                for (int n=m+1; n<len; n++) {
                    swap(m, n, s);
                    int cur = Integer.valueOf(s.toString()); 
                    curSwapMap.put(cur, curSwapMap.getOrDefault(cur, 0) + 1);
                    for (int l=0; l<len-1; l++) {
                        for (int o=l+1; o<len; o++) {
                            swap(l, o, s);
                            cur = Integer.valueOf(s.toString()); 
                            //System.out.println(nums[i] + " " + cur + " " + ans + " " + swapMap);
                            curSwapMap.put(cur, curSwapMap.getOrDefault(cur, 0) + 1);
                            swap(l, o, s);
                        }
                    }
                    swap(m, n, s);
                }
            }
            for (int key : curSwapMap.keySet()) {
                swapMap.put(key, swapMap.getOrDefault(key, 0) + 1);
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