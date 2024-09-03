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

        return !s.contains("01");
    }
}