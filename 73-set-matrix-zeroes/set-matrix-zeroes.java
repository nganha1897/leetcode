class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        boolean firstR = false, firstC = false;
        for (int c=0; c<n; c++) {
            if (matrix[0][c] == 0) {
                firstR = true;
                break;
            }
        }
        for (int r=0; r<m; r++) {
            if (matrix[r][0] == 0) {
                firstC = true;
                break;
            }
        }

        for (int r=1; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (matrix[r][c] == 0) {
                    if ( c != 0) {
                        matrix[r][0] = 0;
                    }
                    break;
                }
            }
        }
        for (int c=1; c<n; c++) {
            for (int r=0; r<m; r++) {
                if (matrix[r][c] == 0) {
                    if ( r != 0) {
                        matrix[0][c] = 0;
                    }
                    break;
                }
            }
        }

        

        for (int r=1; r<m; r++) {
            if (matrix[r][0] == 0) {
                for (int c=0; c<n; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        for (int c=1; c<n; c++) {
            if (matrix[0][c] == 0) {
                for (int r=0; r<m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        
        if (firstR) {
            for (int c=0; c<n; c++) {
                matrix[0][c] = 0;
            }
        }
    
        if (firstC) {
            for (int r=0; r<m; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}