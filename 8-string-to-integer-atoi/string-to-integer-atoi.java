class Solution {
    public int myAtoi(String s) {
        long ans = 0;
        int sign = 1;
        s = s.trim();
        if (s == null || s.length() == 0)
            return 0;
        int pos = 0;
        if (s.charAt(pos) == '-') {
            sign = -1;
            pos++;
        } else if (s.charAt(pos) == '+') {
            pos++;
        }
        while (pos < s.length() && s.charAt(pos) == '0') {
            pos++;
        }
//System.out.println(pos);     

        for (; pos < s.length(); pos++) {
            if (s.charAt(pos) < '0' || s.charAt(pos) > '9') {
                return (int)(ans * sign);
            } else {
                
                long temp = (ans * 10 + s.charAt(pos) - '0') * sign;
                if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    }
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + s.charAt(pos) - '0';
                //System.out.println(pos + " " + ans);
            }
        }
        return (int)(ans * sign);
    }
}