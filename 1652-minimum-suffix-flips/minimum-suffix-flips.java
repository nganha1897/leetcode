class Solution {
    public int minFlips(String target) {
        int ans = 0;
        for (int i=0; i<target.length(); i++) {
            int c = target.charAt(i) - 0;
            if ((c + ans) % 2 == 1)
                ans++;
        }
        return ans;
    }
}