class Solution {
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        int temp;
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n;j++){
                temp= matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        int i=0;
        int j=n-1;
        while(i<j){
            for(int x=0; x<n;x++){
                //swap marr[x][i] to arr[x][j]
                temp= matrix[x][i];
                matrix[x][i]= matrix[x][j];
                matrix[x][j]= temp;
            }
            i++;
            j--;
        }
    }
}