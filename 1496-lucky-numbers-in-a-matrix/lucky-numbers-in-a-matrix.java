class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int r=0; r<m; r++) {
            int min = matrix[r][0];
            int minCol = 0;
            for (int c=0; c<n; c++) {
                if (matrix[r][c] < min) {
                    min = matrix[r][c];
                    minCol = c; 
                }
            }

            if (checkIfMaxInC(matrix, minCol, min))
                ans.add(min);
        }

        return ans;
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