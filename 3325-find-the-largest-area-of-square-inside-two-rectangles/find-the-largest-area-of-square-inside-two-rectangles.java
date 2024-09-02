class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // long ans = 0;
        // for (int i=0; i<bottomLeft.length-1; i++) {
        //     for (int j=i+1; j<bottomLeft.length; j++) {
        //         long minX = Math.min(topRight[i][0], topRight[j][0]);
        //         long maxX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);

        //         long minY = Math.min(topRight[i][1], topRight[j][1]);
        //         long maxY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

        //         long side = Math.min(minX - maxX, minY - maxY);

        //         if (side > 0) {
        //             ans = Math.max(ans, side * side);
        //         }
        //     }
        // }
        // return ans;
        int n=bottomLeft.length, max=0;
        for(int i=0;i<n;i++){
            int l = Math.min(topRight[i][0]-bottomLeft[i][0],topRight[i][1]-bottomLeft[i][1]);
            if (l<=max)
                continue;
            for(int j=i+1;j<n;j++){
                int x1=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int x2=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                int y1=Math.min(topRight[i][0],topRight[j][0]);
                int y2=Math.min(topRight[i][1],topRight[j][1]);
                if(y1>x1 && y2>x2){
                    max=Math.max(max,Math.min(y1-x1,y2-x2));
                }
            }
        }
        return (long)max*max;
    }
}