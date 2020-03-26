package app;

public class App {

    static public int numIslands(char[][] grid) {
        int count = 0;
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    visited[row][column] = true;
                    count++;
                    callDFS(grid, row, column, visited);
                }
            }
        }
        return count;
    }

    static public void callDFS(char[][] grid, int row, int column, boolean[][] visited) {
        if (isSafe(grid, row, column)) {
            return;
        }
        grid[row][column] = '0';
        visited[row][column] = true;
        callDFS(grid, row + 1, column, visited);
        callDFS(grid, row - 1, column, visited);
        callDFS(grid, row, column - 1, visited);
        callDFS(grid, row, column + 1, visited);
    }

    private static boolean isSafe(char[][] grid, int row, int column) {
        return row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == '0';
    }

    public static void main(String[] args) throws Exception {
        char[][] grid = { { '1', '1', '0', '1', '0' }, 
                          { '1', '1', '0', '1', '0' },
                          { '1', '1', '0', '0', '0' },
                          { '0', '0', '0', '0', '0' } };

        System.out.println("Number of Islands = " + numIslands(grid));
    }
}