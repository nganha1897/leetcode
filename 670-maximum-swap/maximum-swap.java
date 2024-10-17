class Solution {
    public int maximumSwap(int num) {
        char[] numc = String.valueOf(num).toCharArray();
        char[] max = new char[numc.length+1];
        for (int i=numc.length-1; i>=0; i--) {
            max[i] = (char)Math.max(numc[i], max[i+1]);
        }
        for (int i=0; i<numc.length-1; i++) {
            if (numc[i] < max[i+1]) {
                for (int j=numc.length-1; j>i; j--) {
                    if (numc[j] == max[i+1]) {
                        numc[j] = numc[i];
                        numc[i] = max[i+1];
                    }
                }
                return Integer.valueOf(String.valueOf(numc));
            }
        }
        return num;
    }
}