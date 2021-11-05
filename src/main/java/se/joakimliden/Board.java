package se.joakimliden;

public class Board {

    public static void main(String[] args) {
        Board board = new Board(10, 10);
        ConsolePrint consolePrint = new ConsolePrint();
        int count = 0;

        board.setAlive(1, 0);
        board.setAlive(2, 1);
        board.setAlive(0, 2);
        board.setAlive(1, 2);
        board.setAlive(2, 2);

        while (count < 32) {
            consolePrint.printGrid(board);
            board.nextGrid();
            count++;
        }
    }

    private final int width;
    private final int height;
    private int[][] grid;
    private int gridGeneration = 1;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[width][height];
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

    public int[][] nextGrid() {
        gridGeneration++;
        int[][] nextGrid = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                nextGrid[x][y] = isAliveNextGrid(y, x);
            }
        }
        this.grid = nextGrid;
        return nextGrid;
    }

    private int isAliveNextGrid(int y, int x) {
        int aliveNeighbours = aliveNeighbours(x, y);
        if (isAlive(x, y) && aliveNeighbours == 2 || aliveNeighbours == 3)
            return 1;
        return 0;
    }

    private boolean isAlive(int x, int y){
        return getState(x, y) == 1;
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
}
