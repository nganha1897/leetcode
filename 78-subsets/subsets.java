class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ss = new ArrayList();
        ss.add(new ArrayList<Integer>());
        for (int i=0; i<nums.length; i++) {
            int size = ss.size();
            System.out.println(size);
            for (int j=0; j<size; j++) {
                List<Integer> dup = new ArrayList(ss.get(j));
                dup.add(nums[i]);
                ss.add(dup);
            }
        }
        return ss;
    }
}