class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) {
                res.append(s.charAt(index++));
            } else {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + s.charAt(index++) - '0';
                }
                index++;
                String decodedStr = decodeString(s);
                index++;
                while (k -- > 0) {
                    res.append(decodedStr);
                }
            }
        }
        return new String(res);
    }
}