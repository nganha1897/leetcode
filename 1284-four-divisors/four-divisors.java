class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        Set<Integer> n = new HashSet<>();
        for (int num : nums) {
            int div = 0;
            
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
            }
            n.clear();
        }
        return sum;
    }
}