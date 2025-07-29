class Solution {
    public void setZeroes(int[][] matrix) {
        int row= matrix.length;
        int col= matrix[0].length;

        int[] arrRow= new int[row];
        int[] arrCol= new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    arrRow[i]=1;
                    arrCol[j]=1;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arrRow[i]==1 || arrCol[j]==1){
                    matrix[i][j]=0;
                }
            }
        }

       /* int row= matrix.length;
        int col=matrix[0].length;
        int[][] arr= new int[row][col];
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    arr[i][j]=1;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==1){
                    for(int k=0;k<col;k++){
                        matrix[i][k]=0;
                        
                    }
                    for(int l=0; l<row;l++){
                        matrix[l][j]=0;
                    }
                }
            }
        } */       
    }
}