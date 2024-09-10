class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int div = 0;
            Set<Integer> n = new HashSet<>();
            for (int i=1; i<=Math.sqrt(num); i++) {
                if (num % i == 0) {
                    div += i * i == num ? 1 : 2;
                    n.add(i);
                    n.add(num / i);
                }
            }
            if (div == 4) {
                for (int i : n) {
                    sum += i;
                }
                // for (int i=1; i<Math.sqrt(num); i++) {
                //     if (num % i == 0 && num / i != i) {
                //         sum += i + num / i;
                //     }
                // }
            }
        }
        return sum;
    }
}