class Solution {
    public int kthFactor(int n, int k) {
        for (int i=1, count=0; i<=n; i++) {
            if (n % i == 0) {
                if (++count == k) {
                    return i;
                }
            }
        }
        return -1;
    }
}