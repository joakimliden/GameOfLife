package se.joakimliden;

public class Board {

    private final int width;
    private final int height;
    private int[][] grid;
    private final ConsolePrint consolePrint = new ConsolePrint();
//    static ConsolePresenter consolePresenter = new ConsolePresenter();

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

    public int[][] nextGrid(int[][] inputGrid) {
        int[][] nextGrid = inputGrid.clone();
        return nextGrid;
    }

    /*private void printGrid(int[][] inputGrid) {

        System.out.println("height = " + height);
        System.out.println("width = " + width);
        int countY
        for (int y = 0; y < height; y++) {
            String grid = "";
            for (int x = 0; x < width; x++) {
                if (inputGrid[x][y] == 0) {
                    grid += "[.]";
                } else {
                    grid += "[*]";
                }
            }
//            grid += "\n";
            System.out.println(grid);
        }
//
//        StringBuilder line = new StringBuilder();
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                if (grid[x][y] == 0) {
//                    line.append("[ ]");
//                } else {
//                    line.append("[*]");
//                }
//            }
//            line.append("\n");
//        }
//        System.out.println(line);
    }*/

    public int setAlive(int x, int y) {
        grid[x][y] = 1;
        return grid[x][y];
    }

    public int countAliveNeighbours(int x, int y) {
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

    public int[][] nextBoard() {
        int[][] nextGrid = new int[width][height];
        /*System.out.println("width = " + width);
        System.out.println("height = " + height);
        System.out.println("***nextGrid***");
        System.out.println(Arrays.deepToString(nextGrid));
        System.out.println("***nextGrid***");*/

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int aliveNeighbours = countAliveNeighbours(x, y);
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
//        consolePrint.printBoard(inputBoard);
        return nextGrid;
    }
}
