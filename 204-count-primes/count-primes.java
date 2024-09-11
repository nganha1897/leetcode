class Solution {
//     public int countPrimes(int n) {
//         if (n <= 2) {
//             return 0;
//         }
//         int ans = 0;
//         boolean[] primes = new boolean[n];
//         Arrays.fill(primes, true);
//         primes[2] = true;
//         for (int i = 2; i < n; i++) {
//             if (primes[i]) {
//                 ans++;
//                 //System.out.println(i);
//                 if (i <= n / i) {
//                     for (int j = i * i; j < n; j += i) {
//                         //System.out.println(i + " " + j);
//                         primes[j] = false;
//                     }
//                 }
//             }
//         }

//         return ans;
//     }

public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for (int i = 3; i < n; i += 2) {
            isPrime[i] = true;
        }
        isPrime[2] = true; 
        for (int i=3; i*i<n; i+=2) {
            if (isPrime[i]) {
                for (int j = i*i; j<n; j+=2*i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i=2; i<n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}