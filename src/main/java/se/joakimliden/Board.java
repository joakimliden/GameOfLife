package se.joakimliden;

public class Board {

    public Board(int width, int height) {
    }

    public static int[][] nextBoard(int[][] inputBoard) {
        return inputBoard.clone();
    }

    public int setAlive(int x, int y) {
        return 0;
    }
}
