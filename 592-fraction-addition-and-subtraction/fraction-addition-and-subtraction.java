class Solution {
    public String fractionAddition(String expression) {
        int n = expression.length();
        if (n == 0) {
            return "0/1";
        }
        Deque<Long> stack = new ArrayDeque<>();
        int num = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '-') {
                if (i != 0) {
                    stack.offerLast((long) num * sign);
                    num = 0;
                }
                sign = -1;
            } else if (c == '+') {
                stack.offerLast((long) num * sign);
                num = 0;
                sign = 1;
            } else if (c == '/') {
                stack.offerLast((long) num * sign);
                num = 0;
                sign = 1;
            } else {
                num = num * 10 + c - '0';
            }
            // System.out.println(stack);
        }
        stack.offerLast((long) num * sign);
        while (stack.size() >= 4)

        {
            long y2 = stack.pollLast();
            long x2 = stack.pollLast();
            long y1 = stack.pollLast();
            long x1 = stack.pollLast();
            long numer = x1 * y2 + x2 * y1;
            long dem = y1 * y2;
            // System.out.println("numerator: " + numer);
            // System.out.println("denominator: " + dem);
            long gcd = gcd(Math.abs(numer), Math.abs(dem));
            numer /= gcd;
            dem /= gcd;
            
            stack.offerLast(numer);
            stack.offerLast(dem);
        }

        StringBuilder ans = new StringBuilder();
        ans.append(stack.pollFirst());
        ans.append("/");
        ans.append(stack.pollFirst());
        return ans.toString();
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}