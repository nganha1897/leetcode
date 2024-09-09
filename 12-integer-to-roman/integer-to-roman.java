class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        int mult = 1;
        while (num > 0) {
            int cur = num % 10;
            if (cur == 4) {
                sb.append(map.get(mult * 5)).append(map.get(mult));
            } else if (cur == 9) {
                sb.append(map.get(mult * 10)).append(map.get(mult));
            } else {
                while (cur > 5) {
                    sb.append(map.get(mult));
                    cur--;
                }
                if (cur == 5) {
                    sb.append(map.get(mult * 5));
                    cur -= 5;
                }
                while (cur > 0) {
                    sb.append(map.get(mult));
                    cur--;
                }
            }
            num /= 10;
            mult *= 10;
        }

        return sb.reverse().toString();
    }
}