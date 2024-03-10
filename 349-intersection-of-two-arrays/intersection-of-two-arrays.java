class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}