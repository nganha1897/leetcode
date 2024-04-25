class Solution {
    public int longestIdealString(String s, int k) {
        int max = 0, c[] = new int[26], n = s.length();
        
        for (int i=0; i<n; i++) {
            int cur = s.charAt(i) - 'a';
            int minC = Math.max(0, cur - k);
            int maxC = Math.min(25, cur + k);
            int curMax = 0;
            for (int j=minC; j<=maxC; j++) {
                curMax = Math.max(curMax, 1 + c[j]);
            }
            c[cur] = curMax;
            max = Math.max(max, c[cur]);           
        }

        return max;
    }
}