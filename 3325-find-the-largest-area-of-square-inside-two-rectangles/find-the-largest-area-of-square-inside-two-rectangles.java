class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        for (int i=0; i<bottomLeft.length-1; i++) {
            for (int j=i+1; j<bottomLeft.length; j++) {
                int xti = topRight[i][0];
                int xbi = bottomLeft[i][0];
                int xtj = topRight[j][0];
                int xbj = bottomLeft[j][0];
                long side1 = Math.min(xti, xtj) - Math.max(xbi, xbj);

                int yti = topRight[i][1];
                int ybi = bottomLeft[i][1];
                int ytj = topRight[j][1];
                int ybj = bottomLeft[j][1];
                long side2 = Math.min(yti, ytj) - Math.max(ybi, ybj);

                if (side1 > 0 && side2 > 0) {
                    ans = Math.max(ans, Math.min(side1, side2) * Math.min(side1, side2));
                }
            }
        }
        return ans;
    }
}