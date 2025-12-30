//4ms
public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};

        Solution solve = new Solution();
        
        System.out.println(solve.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                int current_cell = grid[i][j];
                if (current_cell==1){
                    count+=4;
                    if (i > 0 && grid[i-1][j] == 1){
                        count--;
                    }
                    if (i < grid.length-1 && grid[i+1][j] == 1){
                        count--;
                    }
                    if (j > 0 && grid[i][j-1] == 1){
                        count--;
                    }
                    if (j < grid[i].length -1  && grid[i][j+1] == 1){
                        count--;
                    }

                   
                }
                
            }
        }

        return count;       
    }
}

