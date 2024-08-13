// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> ans = new ArrayList<>();
//         helper(candidates, 0, target, new ArrayList<>(), ans);
//         return ans;
//     }

//     private void helper(int[] candidates, int pos, int target, List<Integer> comb, List<List<Integer>> ans) {
//         if (target == 0) {
//             ans.add(new ArrayList<>(comb));
//             return;
//         }
//         if (pos + 1 < candidates.length) {
//             helper(candidates, pos + 1, target, comb, ans);
//             if (target >= candidates[pos]) {
//                 target -= candidates[pos];
//                 comb.add(candidates[pos]);
//                 int size = comb.size();
//                 helper(candidates, pos + 1, target, comb, ans);
//                 comb.remove(size-1);
//             }
//         }
//     }
// }

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(
        List<List<Integer>> answer,
        List<Integer> tempList,
        int[] candidates,
        int totalLeft,
        int index
    ) {
        if (totalLeft < 0) return;
        else if (totalLeft == 0) { // Add to the answer array, if the sum is equal to target.
            answer.add(new ArrayList<>(tempList));
        } else {
            for (
                int i = index;
                i < candidates.length && totalLeft >= candidates[i];
                i++
            ) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                // Add it to tempList.
                tempList.add(candidates[i]);
                // Check for all possible scenarios.
                backtrack(
                    answer,
                    tempList,
                    candidates,
                    totalLeft - candidates[i],
                    i + 1
                );
                // Backtrack the tempList.
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}