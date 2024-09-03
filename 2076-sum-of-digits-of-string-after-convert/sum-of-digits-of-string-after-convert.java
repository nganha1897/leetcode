class Solution {
    public int getLucky(String s, int k) {
        StringBuilder convert = new StringBuilder();
        int sum = 0;

        for (char c : s.toCharArray()) {
            int pos = c - 'a' + 1;
            while (pos > 0) {
                sum += pos % 10;
                pos /= 10;
            }
        }

        for (int i = 1; i < k; i++) {
            if (sum < 10) {
                return sum;
            }
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