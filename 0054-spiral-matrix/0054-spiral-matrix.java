class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd){
            //Tranverse Right (colBegin -> colEnd)
            for(int i=colBegin;i<=colEnd;i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            //Tranverse Down (rowBegin -> rowEnd)
            for(int i=rowBegin;i<=rowEnd;i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd){
            //Tranverse Left (colEnd -> colBegin)
            for(int i=colEnd;i>=colBegin;i--){
                res.add(matrix[rowEnd][i]);
            }
        }
            rowEnd--;
            if(colBegin <= colEnd){
            //Tranverse Up (rowEnd -> rowBegin)
            for(int i=rowEnd;i>=rowBegin;i--){
                res.add(matrix[i][colBegin]);
            }
        }
            colBegin++;
        }
    return res;
    }
}