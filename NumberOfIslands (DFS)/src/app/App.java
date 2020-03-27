package app;

public class App {

    static public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    count++;
                    callDFS(grid, row, column);
                }
            }
        }
        return count;
    }

    static public void callDFS(char[][] grid, int row, int column) {
        if (isOutOfRange(grid, row, column)) {
            return;
        }
        markSpot(grid, row, column);
        callDFS(grid, row + 1, column);
        callDFS(grid, row - 1, column);
        callDFS(grid, row, column - 1);
        callDFS(grid, row, column + 1);
    }

    private static void markSpot(char[][] grid, int row, int column) {
        grid[row][column] = '0';
    }

    private static boolean isOutOfRange(char[][] grid, int row, int column) {
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