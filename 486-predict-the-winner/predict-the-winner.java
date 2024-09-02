class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length, sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return predict(nums, 0, n - 1, sum, 0, true);
    }

    private boolean predict(int[] nums, int i, int j, int sum, int score, boolean isTurn) {
        if (i == j && !isTurn) {
            return (sum - score) > score;
        } else if (i == j) {
            return (score + nums[i]) >= (sum - score - nums[i]);
        } else {
            if (isTurn) {
                boolean opt1 = predict(nums, i + 1, j, sum, score + nums[i], !isTurn);
                boolean opt2 = predict(nums, i, j - 1, sum, score + nums[j], !isTurn);
                return (!opt1 || !opt2);
            } else {
                boolean opt1 = predict(nums, i + 1, j, sum, score, !isTurn);
                boolean opt2 = predict(nums, i, j - 1, sum, score, !isTurn);
                return (!opt1 || !opt2);
            }
        }
    }
}