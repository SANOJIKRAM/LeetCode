class Solution {
    private int m, n, originalColor, newColor;
    private int[][] grid;
    private boolean[][] visited;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.originalColor = grid[row][col];
        this.newColor = color;
        this.visited = new boolean[m][n];

        // 1. Mark all connected cells from (row,col)
        dfsMark(row, col);

        // 2. For each marked cell, check if it is border and recolor
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] && isBorder(i, j)) {
                    grid[i][j] = newColor;
                }
            }
        }

        return grid;
    }

    private void dfsMark(int r, int c) {
        visited[r][c] = true;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n
                    && !visited[nr][nc] && grid[nr][nc] == originalColor) {
                dfsMark(nr, nc);
            }
        }
    }

    private boolean isBorder(int r, int c) {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                return true; // On the edge of the grid
            }
            if (!visited[nr][nc]) {
                return true; // Adjacent to a cell not in the component
            }
        }
        return false; // Not a border cell
    }
}
