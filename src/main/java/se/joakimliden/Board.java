package se.joakimliden;

public class Board {

    private final int width;
    private final int height;
    public int[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[width][height];
    }

    public int[][] nextGrid() {
        return new int[width][height];
    }

    public int setAlive(int x, int y) {
        grid[x][y] = 1;
        return grid[x][y];
    }

    public int aliveNeighbours(int x, int y) {
        return 0;
    }
}
