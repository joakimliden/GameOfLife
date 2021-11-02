package se.joakimliden;

public class Board {

    private final int width;
    private final int height;
    private final int[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[width][height];
    }

    public static int[][] nextBoard(int[][] inputBoard) {
        return inputBoard.clone();
    }

    public int setAlive(int x, int y) {
        grid[x][y] = 1;
        return grid[x][y];
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        count += this.grid[x - 1][y - 1];
        count += this.grid[x][y - 1];
        count += this.grid[x + 1][y - 1];

        count += this.grid[x - 1][y];

        count += this.grid[x + 1][y];

        count += this.grid[x - 1][y + 1];
        count += this.grid[x][y + 1];
        count += this.grid[x + 1][y + 1];

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width) {
            return 0;
        }

        if (y < 0 || y >= height) {
            return 0;
        }

        return grid[x][y];
    }
}
