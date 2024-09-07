class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = 2000000;
        for (int i=1; i<arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - arr[i-1] == min) {
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return ans;
    }
}