class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int minCol, min;
        List<Integer> ans = new ArrayList<>();
        for (int r=0; r<m; r++) {
            minCol = findMinCInR(matrix,r);
            min = matrix[r][minCol];

            if (checkIfMaxInC(matrix, minCol, min))
                ans.add(min);
        }

        return ans;
    }

    private int findMinCInR(int[][] m,int r){
        int min = 100001,
            minIndex = 0;
        for(int c=0;c<m[r].length;c++){
            if(m[r][c]<min){
                min = m[r][c];
                minIndex = c;
            }
        }
        return minIndex;
    }

    private boolean checkIfMaxInC(int[][]m, int c, int max){
        for(int r=0;r<m.length;r++){
            if(m[r][c]>max){
                return false;
            }
        }
        return true;
    }
}