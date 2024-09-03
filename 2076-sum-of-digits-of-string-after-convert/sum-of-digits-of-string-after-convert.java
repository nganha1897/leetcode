class Solution {
    public int getLucky(String s, int k) {
        StringBuilder convert = new StringBuilder();
        for (char c : s.toCharArray()) {
            convert.append(c - 'a' + 1);
        }
        int sum = 0;
        for (int j = 0; j < convert.length(); j++) {
            sum += convert.charAt(j) - '0';
        }
        if (sum < 10) {
            return sum;
        }
        for (int i = 1; i < k; i++) {
            int temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }
            sum = temp;
        }
        return sum;
    }
}