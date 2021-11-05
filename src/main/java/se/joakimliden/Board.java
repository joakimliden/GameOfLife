package se.joakimliden;

public class Board {

    private final int width;
    private final int height;
    public int[][] grid;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int[][] nextGrid() {
        return new int[width][height];
    }
}
