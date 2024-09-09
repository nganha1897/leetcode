class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int n = s.length();
        int[] one = new int[n+1];
        int[] zero = new int[n+1];

        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                one[i+1] = one[i] + 1;
                int st = i - one[i+1];
                if (zero[st+1] >= one[i+1]) {
                    ans++;
                }
            } else {
                zero[i+1] = zero[i] + 1;
                int st = i - zero[i+1];
                if (one[st+1] >= zero[i+1]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}