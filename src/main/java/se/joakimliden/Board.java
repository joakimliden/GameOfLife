package se.joakimliden;

public class Board {

    private final int[][] grid;

    public Board(int width, int height) {
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
        return 0;
    }
}
