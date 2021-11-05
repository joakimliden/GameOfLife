package se.joakimliden;

public class Board {

    private final int width;
    private final int height;
    private int gridGeneration = 1;
    private int[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getGridGeneration() {
        return gridGeneration;
    }

    public int setAlive(int x, int y) {
        grid[x][y] = 1;
        return grid[x][y];
    }

    public int aliveNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);

        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= width)
            return 0;

        if (y < 0 || y >= height)
            return 0;

        return grid[x][y];
    }

    public int[][] nextGrid() {
        gridGeneration++;
        int[][] nextGrid = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = aliveNeighbours(x, y);
                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2) {
                        nextGrid[x][y] = 0;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        nextGrid[x][y] = 1;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        nextGrid[x][y] = 1;
                    }
                }
            }
        }
        this.grid = nextGrid;
        return nextGrid;
    }
}
