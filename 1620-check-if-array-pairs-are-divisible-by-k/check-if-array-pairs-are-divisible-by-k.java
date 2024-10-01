class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for (int i=0; i<arr.length; i++) {
            int curRem = arr[i] % k;
            if (curRem < 0) curRem += k;
            rem[curRem]++;
        }
        for (int i=0; i<arr.length; i++) {
            int curRem = arr[i] % k;
            if (curRem < 0) curRem += k;
            if (rem[curRem] == 0) {
                continue;
            }
            rem[curRem]--;
            int pair = k - curRem;
            if (pair == k) {
                pair = 0;
            } else if (pair < 0) {
                pair += k;
            }
            if (rem[pair] == 0) {
                return false;
            }
            rem[pair]--;
        }
        return true;
    }
}