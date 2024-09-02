class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxSide = 0;
        for (int i=0; i<bottomLeft.length-1; i++) {
            for (int j=i+1; j<bottomLeft.length; j++) {
                int minX = Math.min(topRight[i][0], topRight[j][0]);
                int maxX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                int minY = Math.min(topRight[i][1], topRight[j][1]);
                int maxY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int curSide = Math.min(minX - maxX, minY - maxY);

                maxSide = Math.max(maxSide, curSide);
            }
        }
        return (long)maxSide * maxSide;
        // int n=bottomLeft.length, max=0;
        // for(int i=0;i<n;i++){
        //     int l = Math.min(topRight[i][0]-bottomLeft[i][0],topRight[i][1]-bottomLeft[i][1]);
        //     if (l<=max)
        //         continue;
        //     for(int j=i+1;j<n;j++){
        //         int x1=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
        //         int x2=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
        //         int y1=Math.min(topRight[i][0],topRight[j][0]);
        //         int y2=Math.min(topRight[i][1],topRight[j][1]);
        //         if(y1>x1 && y2>x2){
        //             max=Math.max(max,Math.min(y1-x1,y2-x2));
        //         }
        //     }
        // }
        // return (long)max*max;
    }
}