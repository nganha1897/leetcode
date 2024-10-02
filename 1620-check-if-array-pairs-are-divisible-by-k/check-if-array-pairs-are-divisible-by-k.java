class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for (int num : arr) {
            int curRem = ((num % k) + k) % k;
            rem[curRem]++;
        }
        for (int num : arr) {
            int curRem = ((num % k) + k) % k;
            if (rem[curRem] > 0) {
                rem[curRem]--;
                int other = k - curRem == k ? 0 : k - curRem;
                if (rem[other] == 0) {
                    return false;
                }
                
                rem[other]--;
            }
        }
        return true;
    }
}