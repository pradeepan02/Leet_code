class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length - 1;
        int col = grid[0].length - 1;

        while(row >= 0 || col >= 0){
            minPathSum(grid, row, col);
            row--;
            col--;
        }

        return grid[0][0];
    }

    private void minPathSum(int[][] grid, int row, int col){
        if(row < 0 || col < 0) return;
        int right = col + 1;
        int down = row + 1;
        for(int r = row; r >= 0; r--){
            if(r + 1 < grid.length || right < grid[0].length){
                grid[r][col] += Math.min(r + 1 < grid.length ? grid[r +  1][col] : Integer.MAX_VALUE,
                right < grid[0].length ? grid[r][right] : Integer.MAX_VALUE);
            }
        }

        for(int c = col - 1; c >= 0; c--){
            if(c + 1 < grid[0].length || down < grid.length){
                grid[row][c] += Math.min(c + 1 < grid[0].length ? grid[row][c + 1] : Integer.MAX_VALUE,
                down < grid.length ? grid[down][c] : Integer.MAX_VALUE);
            }
        }
    }
}