//7ms
public class Solution {
    public static void main(String[] args) {
        int[][] height = {{2,9,3},{5,4,-4},{1,7,1}};

        Solution solve = new Solution();

        System.out.println(solve.maxMatrixSum(height));

    }

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long cnt = 0;
        boolean flag=false;
        int neg = 0;
        int min_abs = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){        
            for (int j = 0; j < n; j++){
                cnt+=Math.abs(matrix[i][j]);
                if (matrix[i][j]==0){
                    flag=true;
                }
                if (matrix[i][j]<0){
                    neg+=1;
                }
                if (min_abs>Math.abs(matrix[i][j])){
                    min_abs=Math.abs(matrix[i][j]);
                }
            }

        }        

        if (flag || neg % 2 == 0){
            return cnt;
        }
        else{
            return cnt-2L*min_abs;
        }
    }
}