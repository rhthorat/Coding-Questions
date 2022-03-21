//Leetcod Q #200
//DFS
class Solution {
  void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    int num_islands = 0;
    for (int r = 0; r < nr; r++) {
      for (int c = 0; c < nc; c++) {
        if (grid[r][c] == '1') {
          num_islands++;
          dfs(grid, r, c);
        }
      }
    }

    return num_islands;
  }
}


//BFS
class Solution {
    public int numIslands(char[][] grid) {
        int rowSize = grid.length;
        
        if (grid == null || rowSize == 0)
            return 0;
        
        int colSize = grid[0].length;
        int islandCount = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    queue.add(r*colSize + c);
                    grid[r][c] = '0';
                    while (!queue.isEmpty()) {
                        int index = queue.poll();
                        int row = index/colSize;
                        int col = index % colSize;
                        
                        if (row > 0 && grid[row - 1][col] == '1') {
                            queue.add((row - 1)*colSize + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row < rowSize - 1 && grid[row+1][col] == '1') {
                            queue.add((row+1)*colSize + col);
                            grid[row+1][col] = '0';
                        }
                        if (col > 0 && grid[row][col-1] == '1') {
                            queue.add(row*colSize + (col - 1));
                            grid[row][col-1] = '0';
                        }
                        if (col < colSize - 1 && grid[row][col+1] == '1') {
                            queue.add(row*colSize + (col+1));
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}