class Solution {
    public int getLucky(String s, int k) {
        StringBuilder convert = new StringBuilder();
        for (char c : s.toCharArray()) {
            convert.append(c - 'a' + 1);
        }
        
        for (int i=0; i<k; i++) {
            int sum = 0;
            for (int j=0; j<convert.length(); j++) {
                sum += convert.charAt(j) - '0';
            }
            if (sum < 10) {
                return sum;
            }
            convert = new StringBuilder(sum + "");
        }
        return Integer.valueOf(convert.toString());
    }
}