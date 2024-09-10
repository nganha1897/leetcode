class Solution {
    public int minimumLevels(int[] possible) {
        int one = 0, n = possible.length;
        for (int i=0; i<possible.length; i++) {
            one += possible[i];
        }
        int cur = 0;
        for (int i=0; i<possible.length-1; i++) {
            cur += possible[i];
            //System.out.println(i + " " + (cur * 2 - i - 1) + " " + ((one - cur) * 2 - n + i + 1));
            if (cur * 2 - i - 1 > (one - cur) * 2 - n + i + 1) {
                return i+1;
            }  
        }

        return -1;
    }
}