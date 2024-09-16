class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> prev = new HashSet<>();
        Set<Triplet> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        prev.add(nums[0]);
        int n = nums.length;
        for (int i=1; i<n-1; i++) {
            for (int k=i+1; k<n; k++) {
                int sum = nums[i] + nums[k];
                if (prev.contains(-sum)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(-sum); list.add(nums[i]); list.add(nums[k]);
                    Collections.sort(list);
                    Triplet t = new Triplet(list.get(0), list.get(1), list.get(2));
                    if (!set.contains(t)) {
                        set.add(t);
                        ans.add(list);
                    }
                }
            }
            prev.add(nums[i]);
        }
        return ans;
    }
}
class Triplet {
    int i;
    int j; 
    int k;

    public Triplet(int a, int b, int c) {
        i = a;
        j = b;
        k = c;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triplet triplet = (Triplet) obj;
        return i == triplet.i && j == triplet.j && k == triplet.k;
    }

    public int hashCode() {
        return Objects.hash(i, j, k);
    }
}