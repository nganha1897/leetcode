class Solution {
    // public int numDupDigitsAtMostN(int n) {
    //     int len = 0, temp = n;
    //     while (temp > 0) {
    //         temp /= 10;
    //         len++;
    //     }
    //     int ans = 0;
    //     for (int i=len-1; i>=1; i--)
    //         ans += unique(len-1);       
    //     ans += prefixUnique(String.valueOf(n).toCharArray());
    //     //System.out.println(uniqueSameLen + " " + n);
    //     return n - ans;
    // }

    // private int prefixUnique(char[] n) {
    //     int[] d = new int[10];
    //     int ans = 0;
    //     for (int i = 0; i < n.length()-1; i++) {
    //         if (d[n.charAt(i)-'0'] == 0) {
    //             d[n.charAt(i)-'0']++;
    //             ans += 
    //         } else {
    //             return ans;
    //         }
    //     }
    //     int last = n.charAt(n.length()-1) - '0';
    //     return ans + (last > 0 ? last - 1 : 0);
    // }

    // private int unique(int len) {
    //     if (len <= 0) {
    //         return 0;
    //     }
    //     int ans = 9, d = 9;
    //     for (int i = 2; i <= len; i++) {
    //         ans *= d--;
    //     }
    //     return ans;
    // }
        public int numDupDigitsAtMostN(int N) {
        // Transform N + 1 to arrayList
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);

        // Count the number with digits < N
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);

        // Count the number with same prefix
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return N - res;
    }


    public int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }
}