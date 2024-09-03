class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroStarts = false;

        if (s.charAt(0) == '0') {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (c == '1') {
                if (zeroStarts) {
                    return false;
                }
            } else {
                zeroStarts = true;
            }    
        }
        return true;
    }
}