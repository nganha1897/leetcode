class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int ans = 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[2] = true;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                ans++;
                //System.out.println(i);
                if (i <= n / i) {
                    for (int j = i * i; j < n; j += i) {
                        //System.out.println(i + " " + j);
                        primes[j] = false;
                    }
                }
            }
        }

        return ans;
    }
}