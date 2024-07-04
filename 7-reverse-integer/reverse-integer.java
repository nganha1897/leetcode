class Solution {
    public int reverse(int x) {
        long temp = 0;
        int xAbs = (int)Math.abs(x);
        while (xAbs > 0) {
            temp = temp * 10 + xAbs % 10;
            xAbs /= 10;
        }
        if ((x >= 0 && temp > Integer.MAX_VALUE) || (x < 0 && -temp < Integer.MIN_VALUE)) {
            return 0;
        }
        return (int) (temp * (x >= 0 ? 1 : -1));
    }
}