class Solution {
    public boolean checkOnesSegment(String s) {
        // boolean zeroStarts = false;

        // for (char c : s.toCharArray()) {
        //     if (c == '1') {
        //         if (zeroStarts) {
        //             return false;
        //         }
        //     } else {
        //         zeroStarts = true;
        //     }    
        // }
        // return true;

        if (s.length() == 1) {
            if (s.charAt(0) == '1') {
                return true;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i+1) == '1') {
                return false;
            }
        }
        return true;
    }
}