class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] preSum = new int[n+1];
        int[] ans = new int[queries.length];

        for (int i=0; i<n; i++) {
            preSum[i+1] = preSum[i];
            if (startEndWithVowel(words[i])) {
                preSum[i+1]++;
            }
        }

        for (int i=0; i<queries.length; i++) {
            ans[i] = preSum[queries[i][1] + 1] - preSum[queries[i][0]];
        }

        return ans;
    }

    private boolean startEndWithVowel(String a) {
        char s = a.charAt(0), e = a.charAt(a.length()-1);
        return isVowel(s) && isVowel(e);
    }

    private boolean isVowel (char s) {
        return (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u');
    }
}