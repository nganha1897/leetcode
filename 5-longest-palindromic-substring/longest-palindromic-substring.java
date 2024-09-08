class Solution {
    // public String longestPalindrome(String s) {
    //     int n = s.length(), len = 0;
    //     int st=0,e=0;
    //     boolean[][] dp = new boolean[n+1][n+1];
    //     for (int i=n-1; i>=0; i--) {
    //         dp[i][i] = true;
    //         for (int j=i+1; j<n; j++) {
    //             if (s.charAt(i) == s.charAt(j)) {
    //                 if (i == j-1) {
    //                     dp[i][j] = true;
    //                 } else 
    //                     dp[i][j] = dp[i+1][j-1];
    //                 if (dp[i][j]) {
    //                     if (j-i+1 > len) {
    //                         len = j - i + 1;
    //                         st=i;
    //                         e=j;
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(st, e+1);
    // }

    public String longestPalindrome(String s) {
        StringBuilder sPrime = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length();
        int[] palindromeRadii = new int[n];
        int center = 0;
        int radius = 0; //right boundary of current rightmost palindrome
        
        for (int i=0; i<n; i++) {
            int mirror = 2 * center - i;

            if (i < radius) {
                palindromeRadii[i] = Math.min(radius - i, palindromeRadii[mirror]);
            }

            while (i + 1 + palindromeRadii[i] < n &&
                   i - 1 - palindromeRadii[i] >= 0 &&
                   sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])
            ) {
                palindromeRadii[i]++;
            }

            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i=0; i<n; i++) {
            if (palindromeRadii[i] > maxLen) {
                maxLen = palindromeRadii[i];
                centerIndex = i;
            }
        }
        int startIndex = (centerIndex - maxLen) / 2;
        return s.substring(startIndex, startIndex + maxLen);
    }
}