class Solution {
    public String removeKdigits(String num, int k) {
        int top=0;
        char[] numAfterRemove = new char[num.length()];
        for (char digit : num.toCharArray()) {
            while (top > 0 && numAfterRemove[top-1] > digit && k > 0) {
                k--;
                top--;
            } 
            numAfterRemove[top++] = digit;
        }
        top -= k;
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        for (int j=0; j<top; j++) {
            if (leadingZero && numAfterRemove[j] == '0')
                continue;
            leadingZero = false;
            res.append(numAfterRemove[j]);
        }
        if (res.length() == 0)
            return "0";
        return res.toString();
    }
}