class Solution {
    public int[][] findFarmland(int[][] land) {
        int rlen = land.length, clen = land[0].length;       
        int[][][] allLand = new int[rlen][clen][4];
        
        for (int r=0; r<rlen; r++) {
            for (int c=0; c<clen; c++) {
                if (land[r][c] == 1) {
                    if ((r-1 >= 0 && land[r-1][c] == 1) || (c-1 >= 0 && land[r][c-1] == 1)) {
                        if (r-1 >= 0 && land[r-1][c] == 1) {
                            allLand[r][c][0] = allLand[r-1][c][0];
                            allLand[r][c][1] = allLand[r-1][c][1];
                        } 
                        if (c-1 >= 0 && land[r][c-1] == 1) {
                            allLand[r][c][0] = Math.max(allLand[r][c][0], allLand[r][c-1][0]);
                            allLand[r][c][1] = Math.max(allLand[r][c][1], allLand[r][c-1][1]);
                        }
                    }                   
                    else {
                        allLand[r][c][0] = r;
                        allLand[r][c][1] = c;
                    }
                    allLand[r][c][2] = r;
                    allLand[r][c][3] = c;
                }
            }
        }
       
        List<int[]> farmland = new ArrayList<>();
        for (int r=rlen-1; r>=0; r--) {
            for (int c=clen-1; c>=0; c--) {
                if (land[r][c] == 1) {
                    if ((r+1 == rlen || (r+1 < rlen && land[r+1][c] == 0)) && (c+1 == clen || (c+1 < clen && land[r][c+1] == 0)))
                        farmland.add(allLand[r][c]);
                }
            }
        }
        
        int[][] res = new int[farmland.size()][4];
        for (int i=0; i<farmland.size(); i++) {
            res[i] = farmland.get(i);
        }
        
        return res;
    }
}