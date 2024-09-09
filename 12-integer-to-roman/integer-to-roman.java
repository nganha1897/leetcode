class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[] symbols = new char[1001];
        symbols[1] = 'I';
        symbols[5] = 'V';
        symbols[10] = 'X';
        symbols[50] = 'L';
        symbols[100] = 'C';
        symbols[500] = 'D';
        symbols[1000] = 'M';
        int mult = 1;
        while (num > 0) {
            int cur = num % 10;
            if (cur == 4) {
                sb.append(symbols[mult * 5]).append(symbols[mult]);
            } else if (cur == 9) {
                sb.append(symbols[mult * 10]).append(symbols[mult]);
            } else {
                while (cur > 5) {
                    sb.append(symbols[mult]);
                    cur--;
                }
                if (cur == 5) {
                    sb.append(symbols[mult * 5]);
                    cur -= 5;
                }
                while (cur > 0) {
                    sb.append(symbols[mult]);
                    cur--;
                }
            }
            num /= 10;
            mult *= 10;
        }

        return sb.reverse().toString();
    }
}