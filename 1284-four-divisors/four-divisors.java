class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int div = 0;
            for (int i=1; i<=Math.sqrt(num); i++) {
                if (num % i == 0) {
                    div += i * i == num ? 1 : 2;
                }
            }
            if (div == 4) {
                for (int i=1; i<Math.sqrt(num); i++) {
                    if (num % i == 0 && num / i != i) {
                        sum += i + num / i;
                    }
                }
            }
        }
        return sum;
    }
}