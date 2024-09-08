class Solution {
    // public int romanToInt(String s) {
    //     int ans = 0, n = s.length();
    //     char[] ch = s.toCharArray();
    //     for (int i=0; i<n; i++) {
    //         if (ch[i] == 'M') {
    //             ans += 1000;
    //         } else if (ch[i] == 'D') {
    //             ans += 500;
    //         } else if (ch[i] == 'C') {
    //             if (i + 1 < n && ch[i+1] == 'D') {
    //                 ans += 400;
    //                 i++;
    //             } else if (i + 1 < n && ch[i+1] == 'M') {
    //                 ans += 900;
    //                 i++;
    //             } else {
    //                 ans += 100;
    //             }
    //         } else if (ch[i] == 'L') {
    //             ans += 50;
    //         } else if (ch[i] == 'X') {
    //             if (i + 1 < n && ch[i+1] == 'L') {
    //                 ans += 40;
    //                 i++;
    //             } else if (i + 1 < n && ch[i+1] == 'C') {
    //                 ans += 90;
    //                 i++;
    //             } else {
    //                 ans += 10;
    //             }
    //         } else if (ch[i] == 'V') {
    //             ans += 5;
    //         } else {
    //             if (i + 1 < n && ch[i+1] == 'V') {
    //                 ans += 4;
    //                 i++;
    //             } else if (i + 1 < n && ch[i+1] == 'X') {
    //                 ans += 9;
    //                 i++;
    //             } else {
    //                 ans += 1;
    //             }
    //         }
    //     }
    //     return ans;
    // }
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int ans = 0;

        for (int i=0; i<s.length(); i++) {
            if (i + 1 < s.length() && m.get(s.charAt(i)) < m.get(s.charAt(i+1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }
}