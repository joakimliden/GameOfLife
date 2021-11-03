package se.joakimliden;

import org.junit.jupiter.api.Test;

import java.io.Console;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void givenAnEmptyGridShouldReturnNewEmptyGrid() {
        int[][] inputGrid = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        assertArrayEquals(inputGrid, Board.nextBoard(inputGrid));
    }

    @Test
    void givenACellIsSetToAliveItIsAlive() {
        Board board = new Board(5, 8);

        assertEquals(1, board.setAlive(2, 2));
    }

    @Test
    void givenACellHasTwoLiveNeighboursItCountsTwoAliveNeighbours() {
        Board board = new Board(5, 8);

        board.setAlive(2, 2);
        board.setAlive(2, 4);

        assertEquals(2, board.countAliveNeighbours(2, 3));
    }

    @Test
    void checkingStateForCellOutsideGridShouldReturn0() {
        Board board = new Board(5, 8);

        assertEquals(0, board.getState(6, -1));
    }

    @Test
    void checkingStateForAliveCellShouldReturn1() {
        Board board = new Board(5, 8);

        board.setAlive(2, 2);

        assertEquals(1, board.getState(2, 2));
    }

    @Test
    void checkingStateForDeadCellShouldReturn0() {
        Board board = new Board(5, 8);

        assertEquals(0, board.getState(2, 2));
    }

    @Test
    void checkingForAliveNeighboursOutsideOfGridShouldReturn0() {
        Board board = new Board(5, 8);

        assertEquals(0, board.countAliveNeighbours(0, 8));
    }

    @Test
    void checkingThatPrintBoardMethodHasExpectedOutcomeForEmptyBoard() {
        Board board = new Board(5,8);
        ConsolePresenter consolePresenter = new ConsolePresenter();

        String expected =
                "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]\n" +
                        "[ ][ ][ ][ ][ ]";

        assertEquals(expected, consolePresenter.printBoard(board));
    }
}
