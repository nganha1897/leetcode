class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int pos = 0;
        while (num > 0) {
            ans = (((num & 1) ^ 1) << pos) ^ ans;
            num >>= 1;
            pos++;
        }
        return ans;
    }
}