class Solution {
    public int subarraysWithKDistinct(int[] A, int k) {
        int res = 0, prefix = 0, len = A.length;
        int[] m = new int[len + 1];
        for (int i=0, j=0, cnt=0; i<len; i++) {
            if (m[A[i]]++ == 0)
                cnt++;
            if (cnt > k) {
                --m[A[j++]];
                --cnt;
                prefix = 0;
            }
        
            while (m[A[j]] > 1) {
                ++prefix;
                --m[A[j++]];
            }
        
            if (cnt == k)
                res += prefix + 1;
        }
        return res;
    }
}